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
        	
            String[] URI = new String[6];
            URI[0]="http://dbpedia.org/resource/Silvio_Berlusconi";
            URI[1]="http://dbpedia.org/resource/Forza_Italia";
            URI[2]="http://dbpedia.org/resource/Denis_Verdini";
            URI[3]="http://dbpedia.org/resource/Chamber_of_Deputies_(Italy)";
            URI[4]="http://dbpedia.org/resource/Milan";
            URI[5]="http://dbpedia.org/resource/Barack_Obama";
        	
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
        	
        	long estimatedTime = System.currentTimeMillis() - startTime;
    		System.out.println(estimatedTime);
        	
        	if (to!=null){
        		for (int i=0; i<URI.length; i++){
        			for (int j=0; j<URI.length; j++){
        				System.out.print(to.getEntry(i, j)+" ");
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