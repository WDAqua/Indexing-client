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
        	/*
        	Integer a=0;
        	String S="tic; a=I3([";
        	String[] ind=new String[200];
        	for (int i=0; i<200; i++){
        		a=(int)(Math.random() * ((100000) + 1));
        		ind[i]=a.toString();
        	}
        	S+=String.join(",", ind);
        	S+="],[";
        	S+=String.join(",", ind);
        	S+="]); toc;";
        	System.out.println(S);
        	*/	
        	
        	
        	
        	/*
            Endpoint dbpedia = new Endpoint();
            System.out.println("Searching ...");
        	//String[] URI1 = dbpedia.find("Space_rock");
        	//String[] URI2 = dbpedia.find("Latin_jazz");
        	String[] URI1 = new String[1];
        	String[] URI2 = new String[1];
            URI1[0]="http://dbpedia.org/resource/Latin_jazz";
        	URI2[0]="http://dbpedia.org/resource/Space_rock";
            
        	for (String s:URI1){
        		System.out.println(s);
        	}
        	for (String s:URI2){
        		System.out.println(s);
        	}*/
        	//String[] URI = ArrayUtils.addAll(URI1, URI2);
        	
        	/*
        	InputStream file = new FileInputStream("/Users/Dennis/Downloads/mapIn");
		    InputStream buffer = new BufferedInputStream(file);
		    ObjectInput input = new ObjectInputStream (buffer);
        	String[] URItemp = new String[360];
        	HashMap<String,Integer> mapIn = (HashMap<String,Integer>)input.readObject();
        	int i=0;
        	Scanner in = new Scanner(new FileReader("/Users/Dennis/Downloads/uri_2.txt"));
        	try {
        	    while (in.hasNext()) {
        	    	String s=in.nextLine();
        			
        		    System.out.println(s.substring(1, s.length()-1));
        			if (mapIn.containsKey(s.substring(1, s.length()-1))){
        				URItemp[i]=s.substring(1, s.length()-1);
        				System.out.println(URItemp[i]);
        				i++;
        				System.out.println("yes");
        				
        			} else {
        				System.out.println("no");
        			}
        	    	//System.out.println("Before:"+ s);
        	    	//String s=s2.replaceFirst("dbpedia.org", "it.dbpedia.org");
        	    	//System.out.println("After:"+ s);
        	        //Endpoint a = new Endpoint();
        	        //if (a.find(s)){
        	        	//String IP=s.substring(1, s.length()-1);
            	        //IP=IP.replaceFirst("://", "://it.");
            	    	//System.out.println(IP);
            	    	
            	    			//s2.substring(1, s2.length()-1);
        	    		
        	    		
        	        //}
        	    }
        	} finally {
        	    in.close();
        	}
        	buffer.close();
        	
        	String[] URI = new String[i];
        	for (int j=0; j<i; j++){
        		URI[j]=URItemp[j];
        		System.out.println(URI[j]);
        	}
        	*/
        	
        	
            String[] URI = new String[5];
            URI[0]="http://dbpedia.org/resource/Silvio_Berlusconi";
            URI[1]="http://dbpedia.org/resource/Forza_Italia";
            URI[2]="http://dbpedia.org/resource/Denis_Verdini";
            URI[3]="http://dbpedia.org/resource/Chamber_of_Deputies_(Italy)";
            URI[4]="http://dbpedia.org/resource/Pier_Silvio_Berlusconi";
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
        		for (int i1=0; i1<URI.length; i1++){
        			for (int j=0; j<URI.length; j++){
        				//if (to.)
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
            System.err.println("Don't know about host ???");
            System.exit(1);
        } catch (IOException e) {
        	System.out.println(e);
        	System.out.println(e.getMessage());
            System.err.println("Couldn't get I/O for the connection to ???");
            System.exit(1);
        } 
        
   
        
    }
}