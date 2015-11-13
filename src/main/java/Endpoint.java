import java.util.ArrayList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

public class Endpoint {
	public boolean find(String entity){
		System.out.println("Endpoint");
		String s2 = 
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"PREFIX owl: <http://www.w3.org/2002/07/owl#> " +		
			"SELECT ?s WHERE { "+
			//"?s rdfs:label ?label . "+
			//"?label <bif:contains> \""+entity+"\" . "+
			entity + "rdfs:label ?s" +
			//"FILTER langMatches( lang(?label), \"IT\" ). "+ 
			//"?s rdf:type owl:Thing "+ 
			"} limit 100 ";
		Query query = QueryFactory.create(s2); //s2 = the query above
		QueryExecution qExe = QueryExecutionFactory.sparqlService( "http://it.dbpedia.org/sparql", query );
		ResultSet result=qExe.execSelect();
		ArrayList<String> list = new ArrayList<String>();
		while (result.hasNext()){
			//list.add(result.next().getResource("s").toString());
			//System.out.println(i.get(result.next().getResource("s").toString()));
			return true;
		}
		String[] r = new String[list.size()];
		return false;
		//return list.toArray(r);
	}
}
