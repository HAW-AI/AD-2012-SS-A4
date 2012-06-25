package aufgabe2;

import java.io.FileNotFoundException;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Ausgabe3 {

	public static void main(String[] args) throws FileNotFoundException{
		GraphParser parser = GraphParser.getInstance();
		Graph<String, DefaultWeightedEdge> graph1 = parser.loadGraphFrom("src/aufgabe2/graph1.graph");
		System.out.println("Graph: " + graph1);
		System.out.println("Quelle: q, Senke: s3");
		System.out.println("Maximale Kapazitaet: " + GraphUtilitys.fordUndFulkerson(graph1, "q", "s3") + "  (Soll: 4)");
		System.out.println();
		
		System.out.println("Graph: " + graph1);
		System.out.println("Quelle: q, Senke: s2");
		System.out.println("Maximale Kapazitaet: " +GraphUtilitys.fordUndFulkerson(graph1, "q", "s2") + "  (Soll: 5)");
		System.out.println();
		
		Graph<String, DefaultWeightedEdge> graph2 = parser.loadGraphFrom("src/aufgabe2/graph2.graph");
		System.out.println("Graph: " + graph2);
		System.out.println("Quelle: q, Senke: s");
		System.out.println("Maximale Kapazitaet: " +GraphUtilitys.fordUndFulkerson(graph2, "q", "s") + "  (Soll: 5)");
		System.out.println();
		
//		Graph<String, DefaultWeightedEdge> graph8 = parser.loadGraphFrom("src/aufgabe2/graph8.graph");
//		System.out.println(GraphUtilitys.fordUndFulkerson(graph8, "Hamburg", "Muenchen"));
//		System.out.println();
//		
//		Graph<String, DefaultWeightedEdge> graph9 = parser.loadGraphFrom("src/aufgabe2/graph9.graph");
//		System.out.println(GraphUtilitys.fordUndFulkerson(graph9, "Quelle", "Senke"));
//		System.out.println();
//		
//		Graph<String, DefaultWeightedEdge> graphNEG = parser.loadGraphFrom("src/aufgabe2/graphNEG.graph");
//		System.out.println(GraphUtilitys.fordUndFulkerson(graphNEG, "Quelle", "Senke"));
//		System.out.println();
//		
//		Graph<String, DefaultWeightedEdge> nichtZusammenhaengend = parser.loadGraphFrom("src/aufgabe2/nichtZusammenh.graph");
//		System.out.println(GraphUtilitys.fordUndFulkerson(nichtZusammenhaengend, "q", "s"));
//		System.out.println();

	}
}
