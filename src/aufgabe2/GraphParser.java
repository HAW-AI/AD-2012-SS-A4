package aufgabe2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jgrapht.Graph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

public class GraphParser {

	//singleton-pattern: nur eine Instanz dieser Klasse erstellbar 
	private static GraphParser instance = new GraphParser();
	
	//Sichtbarkeit des Konstruktors einschraenken
	private GraphParser(){ 
	}
	
	//statische getInstance Methode
	public static GraphParser getInstance(){
		return instance;
	}
	
	private boolean isGraphFile(String filepath){
		return filepath.endsWith("graph");
	}
	
	public Graph<String, DefaultWeightedEdge> loadGraphFrom(String filepath) throws FileNotFoundException{
		
		//pruefen, ob es sich um ein .graph file handelt 
		if (!isGraphFile(filepath)){
			throw new IllegalArgumentException("'" + filepath + "' is not a .graph file");
		}
		
		File file = new File(filepath);
		Scanner graphdata;
		
		//wirft eine FileNotFoundException, wenn File nicht vorhanden
		graphdata = new Scanner(file);

		WeightedGraph<String, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		DefaultWeightedEdge aktEdge;
		

		//Graph einlesen:
		while(graphdata.hasNext()){
			String aktSting = graphdata.next().trim();
								
			String[] aktAry = aktSting.split(",");
			String ecke1 = aktAry[0].trim();
			String ecke2 = aktAry[1].trim();
			Double weight = Double.parseDouble(aktAry[2].trim());
			if(!graph.containsVertex(ecke1)){
				graph.addVertex(ecke1);
			}
			if(!graph.containsVertex(ecke2)){
				graph.addVertex(ecke2);
			}
			
			if (!graph.containsEdge(ecke1, ecke2)){
				aktEdge = graph.addEdge(ecke1, ecke2);
				graph.setEdgeWeight(aktEdge, weight);
				aktEdge = graph.addEdge(ecke2, ecke1);
				graph.setEdgeWeight(aktEdge, weight);
			}else{
				aktEdge = graph.getEdge(ecke1, ecke2);
				graph.setEdgeWeight(aktEdge, graph.getEdgeWeight(aktEdge) + weight);
				aktEdge = graph.getEdge(ecke2,ecke1);
				graph.setEdgeWeight(aktEdge, graph.getEdgeWeight(aktEdge) + weight);
			}
		}
		return graph;
	}
}
