package aufgabe2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * julian und daniela
 * 
 * */
public class GraphUtilitys {
	
	
	//Rueckgabe: Maximalfluss
		public static double fordUndFulkerson(Graph<String, DefaultWeightedEdge> graph, String quelle, String senke){
			
			//Kante -> Kapazitaet
			Map<DefaultWeightedEdge, Double> kapazitaet = new HashMap<DefaultWeightedEdge, Double>();
			for(DefaultWeightedEdge e : graph.edgeSet()){
				kapazitaet.put(e, graph.getEdgeWeight(e));
			}
				
			//Initialisierung:
			//Kante -> Fluss
			Map<DefaultWeightedEdge, Double> fluss = new HashMap<DefaultWeightedEdge, Double>();
			for(DefaultWeightedEdge e : graph.edgeSet()){
				fluss.put(e, 0d);
			}
			
			
			//Initialisierung 2.Teil
			//Ecke -> vorgaengerEcke
			Map<String, String> vorgaenger = new HashMap<String, String>();
			vorgaenger.put(quelle, quelle);
			//Ecke -> vorzeichen Vorgaengerecke ( + fuer Vorwaerts, - fuer Rueckwaertskante)
			Map<String, String> kantenrichtung = new HashMap<String, String>();
			//Ecke -> Inkrement(Double)
			Map<String, Double> inkrement = new HashMap<String, Double>();
			inkrement.put(quelle, Double.POSITIVE_INFINITY);
			//enthaelt alle schon inspizierten Ecken
			Set<String> inspiziert = new HashSet<String>();
			
			
			//solange noch nicht alle markierten Ecken auch inspiziert wurden 
			while(inspiziert.size() < vorgaenger.size()){ 
				//eine beliebige markierte aber noch nicht inzsizierte Ecke waehlen:
				String eckeZuInspizieren = null;
				for(String ecke : vorgaenger.keySet()){
					if(!inspiziert.contains(ecke) && eckeZuInspizieren == null){
						eckeZuInspizieren = ecke;
						inspiziert.add(ecke);
					}
				}
				
				for (String ecke :graph.vertexSet()){
					if(!vorgaenger.keySet().contains(ecke)){
						//Vorwaertskante vorhanden und fluss noch erhoehbar
						if(graph.containsEdge(eckeZuInspizieren, ecke) && kapazitaet.get(graph.getEdge(eckeZuInspizieren, ecke))> fluss.get(graph.getEdge(eckeZuInspizieren, ecke))){
							vorgaenger.put(ecke, eckeZuInspizieren);
							kantenrichtung.put(ecke, "+");
							double minimum = Math.min(inkrement.get(eckeZuInspizieren), (kapazitaet.get(graph.getEdge(eckeZuInspizieren, ecke)) - fluss.get(graph.getEdge(eckeZuInspizieren, ecke))));
							inkrement.put(ecke, minimum);
						}
						//Rueckwaertskante vorhanden und Fluss vorhanden (d.h. erniedrigbar)
						if(graph.containsEdge(ecke, eckeZuInspizieren) && fluss.get(graph.getEdge(ecke, eckeZuInspizieren)) > 0){
							vorgaenger.put(ecke, eckeZuInspizieren);
							kantenrichtung.put(ecke, "-");
							double minimum = Math.min(inkrement.get(eckeZuInspizieren), fluss.get(graph.getEdge(ecke,eckeZuInspizieren)));
							inkrement.put(ecke, minimum);
						}
					}
				}
				
				//wenn Senke erreicht, den gefundenen vergroe�ernden Weg um das Inkrement erhoehen/erniedrigen, das bei der Senke eingetragen ist  
				if(vorgaenger.keySet().contains(senke)){
					double inkr = inkrement.get(senke);
					String aktEcke = senke;
					String aktVor;
					Double aktFluss;
					
					//Zum nachvollziehen des Vergroessernden Weges:
					String weg = aktEcke;
					
					//Weg zurueckverfolgen
					while(aktEcke != quelle){
						aktVor = vorgaenger.get(aktEcke);
						if(kantenrichtung.get(aktEcke).equals("+")){ 	//vorwaertskante
							aktFluss = fluss.get(graph.getEdge(aktVor, aktEcke));
							fluss.put(graph.getEdge(aktVor, aktEcke), aktFluss + inkr);
						}else{											//rueckwaertskante
							aktFluss = fluss.get(graph.getEdge(aktEcke, aktVor));
							fluss.put(graph.getEdge(aktEcke, aktVor), aktFluss - inkr);
						}
						
						aktEcke = aktVor;
						
						weg = aktEcke + ", " + weg;
					}
					
					//und dann auch wieder die Hashes und sets reseten:
					//Initialisierung 2.Teil wiederholen:
					//Ecke -> vorgaengerEcke
					vorgaenger = new HashMap<String, String>();
					vorgaenger.put(quelle, quelle); //einfach Vorgaenger der Quelle, wie bei Djikstra sich selbst gesetzt
					//Ecke -> vorzeichen Vorgaengerecke ( + fuer Vorwaerts, - fuer Rueckwaertskante)
					kantenrichtung = new HashMap<String, String>();
					//Ecke -> Inkrement(Double)
					inkrement = new HashMap<String, Double>();
					inkrement.put(quelle, Double.POSITIVE_INFINITY);
					//enthaelt alle schon inspizierten Ecken
					inspiziert = new HashSet<String>();
				}
			}
			
			double gesFluss = 0;
			for (Map.Entry<DefaultWeightedEdge, Double> tupel : fluss.entrySet()){
				if(graph.getEdgeSource(tupel.getKey()).equals(quelle))
					gesFluss += tupel.getValue();
					
			}
			
			//ganz am Ende, kein vergroessernder Weg mehr gefunden wurde:	
			return gesFluss;
		}

}
