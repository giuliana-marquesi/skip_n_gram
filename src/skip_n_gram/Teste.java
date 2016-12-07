package skip_n_gram;

import java.io.File;
import java.util.Scanner;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;


public class Teste {
	

	public static void main(String[] args){
		int i = 0;
		Vertex v1;
		Vertex v2;
		OrientGraph graph;
		String nomeVertex = new String("vertice");
		String nomeEdge = new String("aresta");
		
		graph = new OrientGraph("remote:localhost:2424/s_n_g");
		v1 = graph.addVertex(null);
		v2 = graph.addVertex(null);
		graph.createVertexType(nomeVertex);
		graph.createEdgeType(nomeEdge);
		graph.commit();
		
		for(i = 0; i < 10; i++){
			graph.addVertex("class:"+nomeVertex, "word", i);
			for( Vertex v : graph.getVertices(nomeVertex+".name", i-1)) {
				v1 = v;
			}
			for( Vertex v : graph.getVertices(nomeVertex+".name", i)) {
				v2 = v;
			}
			v1.addEdge(nomeEdge,v2);
			graph.commit();
		}
		graph.shutdown();
	}
}
