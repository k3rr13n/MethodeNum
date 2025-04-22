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

    public String getString(Graph<String, DefaultEdge> graph){
		
		return "";
	}

	public static void main(String[] args) throws IOException {
		Graph<String, DefaultEdge> graph;
		graph = new SimpleGraph<>(DefaultEdge.class);

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

		/*System.out.println(graph);
		Set<String> inactifs = new HashSet<>();
		for( String v : graph.vertexSet()){
			if(graph.degreeOf(v)<20)
				inactifs.add(v);
		}
		graph.removeAllVertices(inactifs);*/


		DOTExporter<String, DefaultEdge> exporter = new DOTExporter<String, DefaultEdge>();
		exporter.setVertexAttributeProvider((x) -> Map.of("label", new DefaultAttribute<>(x, AttributeType.STRING)));
		exporter.exportGraph(graph, new FileWriter("grapheExo1.dot"));
	}

}
