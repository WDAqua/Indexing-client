import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.linear.OpenMapRealMatrix;
import org.apache.jena.query.ResultSet;
 
public class Client2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
        	
            String[] URI = new String[15753];
	    
	    URI[0]="http://dbpedia.org/resource/Bruce_Springsteen";
            URI[1]="http://dbpedia.org/ontology/Song";

            URI[0]="http://dbpedia.org/resource/Ingrid_Bergman";
            URI[1]="Date";
            //URI[2]="http://dbpedia.org/ontology/Person";
	    //URI[4]="http://dbpedia.org/resource/Pier_Silvio_Berlusconi";
        

	    int i=0;
	    Scanner in = new Scanner(new FileReader("/home_expes/dd77474h/Indexing-client/list"));
	    //try {
              while (in.hasNext()) {
        	 URI[i]=in.nextLine();
		 URI[i]=URI[i].substring(1, URI[i].length() - 1);
		 System.out.println(URI[i]); 
		 i++;
	      }
            //}

            Socket socket = new Socket("localhost", 1112);
        	
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            long startTime = System.currentTimeMillis();
            System.out.println("Sending ...");
            oos.writeObject(URI);
            
            System.out.println("Sent!");	
            
            InputStream is = socket.getInputStream();
        	ObjectInputStream ois = new ObjectInputStream(is);
        	OpenMapRealMatrix to = (OpenMapRealMatrix)ois.readObject();
        
		FileOutputStream fout = new FileOutputStream("/home_expes/dd77474h/Indexing-client/matrix_similarity");
        	ObjectOutputStream OOS = new ObjectOutputStream(fout);
        	OOS.writeObject(to);
	
        	long estimatedTime = System.currentTimeMillis() - startTime;
    		System.out.println(estimatedTime);
        	
        	if (to!=null){
        		for (int i1=0; i1<URI.length; i1++){
        			for (int j=0; j<URI.length; j++){
        				System.out.print(to.getEntry(i1, j)+" ");
        			}
        			System.out.print("\n");
        		}
        	}
        	
        	oos.close();
        	os.close();
        	ois.close();
        	is.close();
        	socket.close();
    		
    		
    		
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ???"+ e);
            System.exit(1);
        } catch (IllegalArgumentException e) {
        	System.out.println(e.getMessage());
        } catch (IOException e) {
        	System.out.println(e);
        	System.out.println(e.getMessage());
            System.err.println("Couldn't get I/O for the connection to ???");
            System.exit(1);
        } 
        
   
        
    }
}
