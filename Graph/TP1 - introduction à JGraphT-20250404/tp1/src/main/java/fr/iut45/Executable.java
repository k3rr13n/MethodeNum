package fr.iut45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.nio.AttributeType;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.nio.csv.CSVImporter;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.util.SupplierUtil;

import java.util.List;
import java.util.ArrayList;


public class Executable {

	public static Graph<String, DefaultEdge> loadHeroes() {
		Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(SupplierUtil.createStringSupplier(1),
				SupplierUtil.DEFAULT_EDGE_SUPPLIER, false);
		CSVImporter<String, DefaultEdge> importer = new CSVImporter<>(CSVFormat.EDGE_LIST);
		importer.setVertexFactory(id -> id);
		importer.importGraph(graph, new File("extrait_marvel.csv"));
		return graph;
	}

	public static Graph<String, DefaultEdge> loadLettre() {
		Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(SupplierUtil.createStringSupplier(1),
				SupplierUtil.DEFAULT_EDGE_SUPPLIER, false);

		return graph;
	}

    public static String getString(Graph<String, DefaultEdge> graph){
		List<DefaultEdge> liste = new ArrayList<>(graph.edgeSet());
		List<String> listeV = new ArrayList<>(graph.vertexSet());
		//System.out.println(graph);
		//System.out.println(graph.vertexSet());
		//System.out.println(graph.edgeSet());
		//DefaultEdge edge = (DefaultEdge) ;
		//liste.add(edge);

		String sEdge = "{";
		for (int i=0; i<liste.size()-1; i++){
			sEdge += graph.getEdgeSource(liste.get(i));
			sEdge += "--";
			sEdge += graph.getEdgeTarget(liste.get(i));
			sEdge += ", ";
		}
		sEdge += graph.getEdgeSource(liste.get(liste.size()-1));
		sEdge += "--";
		sEdge += graph.getEdgeTarget(liste.get(liste.size()-1));
		sEdge += "}";
		System.out.println(sEdge);

		String sVertex = "{";
		for (int i=0; i<listeV.size()-1; i++){
		sVertex += listeV.get(i);
		sVertex += ", ";
		}
		sVertex += listeV.get(listeV.size()-1);
		sVertex += "}, ";
		System.out.println(sVertex + sEdge);

		/*vertexSet()
		edgeSet()
		getEdgeTarget(E e)
		getEdgeSource(E e)*/
		return sVertex + sEdge;

	}

	public static int getDegreMax(Graph<String, DefaultEdge> graph){
		List<String> liste = new ArrayList<>(graph.vertexSet());
		int degree = 0;
		for (int i=0; i<liste.size()-1; i++){
			if (graph.degreeOf(liste.get(i)) > degree){
				degree = graph.degreeOf(liste.get(i));
			}
		}
		System.out.println(degree);
		return degree;
	}


	public static void main(String[] args) throws IOException {
		String res = "";
		int ddegre = 0;
		Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

		graph.addVertex("a");
		graph.addVertex("b");
		graph.addVertex("c");
		graph.addVertex("d");
		graph.addVertex("e");
		graph.addEdge("a", "b");
		graph.addEdge("b", "c");
		graph.addEdge("c", "a");
		graph.addEdge("c", "d");
		graph.addEdge("d", "e");
		//graph = loadLettre();
		res = getString(graph);
		ddegre = getDegreMax(graph);
		/*Set<String> inactifs = new HashSet<>();
		for( String v : graph.vertexSet()){
			if(graph.degreeOf(v)<20)
				inactifs.add(v);
		}
		graph.removeAllVertices(inactifs);*/


		DOTExporter<String, DefaultEdge> exporter = new DOTExporter<String, DefaultEdge>();
		exporter.setVertexAttributeProvider((x) -> Map.of("label", new DefaultAttribute<>(x, AttributeType.STRING)));
		exporter.exportGraph(graph, new FileWriter("grapheExo1.dot"));
		//System.out.println(graph);
	}

}
