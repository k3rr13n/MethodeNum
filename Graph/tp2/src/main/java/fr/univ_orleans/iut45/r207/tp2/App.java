package fr.univ_orleans.iut45.r207.tp2;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.util.SupplierUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Hello JGraphT!
 */
public class App {

	public static List<String> getNeighborsListOF (Graph<String,DefaultEdge> g, String u){
		List<String> neighbors = new ArrayList<>();
		for (DefaultEdge edges : g.edgesOf(u)){
			String source = g.getEdgeSource(edges);
			String target = g.getEdgeTarget(edges);
			if(source.equals(u))
				neighbors.add(target);
			else
				neighbors.add(source);
		}
		return neighbors;
	}

	public static Set<String> getUnionVois(Graph<String,DefaultEdge> g, String u, String v){
		if (!(g.containsVertex(u))||!(g.containsVertex(v)))
			return new HashSet<>();
		Set<String> set = new HashSet<>();
		set.addAll(getNeighborsListOF(g, u));
		set.addAll(getNeighborsListOF(g, v));
		return set;
	}

	public static Set<String> getNeighborsWoutV (Graph<String,DefaultEdge> g, String u, String v){ // compilation marche pas
		if (!(g.containsVertex(u))||!(g.containsVertex(v)))
			return new HashSet<>();
		List<String> neighbors = new ArrayList<>();
		Set<String> set = new HashSet<>();
		neighbors.addAll(getNeighborsListOF(g, v));
		set.addAll(getNeighborsListOF(g, u));
		set.addAll(getNeighborsListOF(g, v));
		set.removeAll(neighbors);
		return set;
	}
	
	public static boolean getUnionVois2(Graph<String,DefaultEdge> g, String u, String v){ // a comprendre
		Set<String> voisUnotV = getNeighborsWoutV(g,u,v);
		Set<String> voisUnotU = getNeighborsWoutV(g,v,u);
		return voisUnotV.size() == 0 && voisUnotU.size() == 0;
	}

	/* CORRECTION sous-graphe1
	public static Graph<String,DefaultEdge> sousGraphInduit(Graph<String,DefaultEdge> g, List<String> u){
		Graph<String, DefaultEdge> sousGraphe = new SimpleGraph<>(DefaultEdge.class);

		//Ajouter les sommets de s
		for (String sommet : S){
			sousGraphe.addVertex(sommet);
		}
		//Ajouter les aretes qui existent dans G entre les sommet de S
		for (String u : S){
			for (String v : S){
				if (!u.equals(v) && G.containsEdge(u,v))
					sousGraphe.addEdge(u,v);
			}
		}
		return sousGraphe;
	*/


	/* MON MIEN
	public static Graph<String,DefaultEdge> sousGraphInduit(Graph<String,DefaultEdge> g, List<String> u){
		Graph<String, DefaultEdge> sousGraphe = new SimpleGraph<>(DefaultEdge.class);

			for (String sommet : u){
				sousGraphe.addVertex();
			}
	}
	*/

	/* CORRECTION sous-graphe2
	public static Graph<String,DefaultEdge> supprimerAretes(Graph<String,DefaultEdge> G, List<String> S){
	// Copie du graphe g afin de ne pas le modifier
	Graph<String, DefaultEdge> graphe = new SimpleGraph<>(DefaultEdge.class);

	// Copie des sommets
	for (String sommet : G.vertexSet()) {
		Graphe.addVertex(sommet);
	}

	// Copie des aretes
	for (DefaultEdge arete : G.edgeSet()){
		String source = G.getEdgeSource(arete);
		String target = G.getEdgeTarget(target);
		Graphe.addEdge(source, target);
	}

	// Supprime les aretes de la liste S de le Graphe
	for (DefaultEdge arete : S) {
		String source = G.getEdgeSource(arete);
		String target = G.getEdgeTarget(target);
		DefaultEdge edgeToRemove = Graphe.getEdge(source, target);
		if (edgeToRemove != null)
			Graphe.removeEdge(edgeToRemove);
	}
	return Graphe;
	*/

	/* MON MIEN
	public static Graph<String,DefaultEdge> graphSans(Graph<String,DefaultEdge> g, List<String> u){
		Graph<String, DefaultEdge> graphe = new SimpleGraph<>(DefaultEdge.class);
	*/

//sous-graphe3
	public static boolean chaineElementaire(List<String> chaine){
		Set<String> ensemble = new HashSet<>(chaine);
		if (chaine.size() == ensemble.size())
			return true;
		return false;
	}

	
	public static void main(String[] args) {
		
		Graph<String, DefaultEdge> graph = GraphTypeBuilder
				.directed()
				.allowingMultipleEdges(true)
				.allowingSelfLoops(true)
				.vertexSupplier(SupplierUtil.createStringSupplier())
				.edgeSupplier(SupplierUtil.createDefaultEdgeSupplier())
				.buildGraph();

		String v0 = graph.addVertex();
		String v1 = graph.addVertex();
		String v2 = graph.addVertex();

		graph.addEdge(v0, v1);
		graph.addEdge(v1, v2);
		graph.addEdge(v0, v2);

		for (String v : graph.vertexSet()) {
			System.out.println("vertex: " + v);
		}

		for (DefaultEdge e : graph.edgeSet()) {
			System.out.println("edge: " + e);
		}
		
	}
	
}
