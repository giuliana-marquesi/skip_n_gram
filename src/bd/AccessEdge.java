package bd;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;


public class AccessEdge {
	
	private OrientGraph graph;
	private String edgeName;
	private Edge edge;

	public AccessEdge(String string) {
		// TODO Auto-generated constructor stub
		System.out.println("instanciou AccessEdge. Nome da classe: "+ string);
		
		graph = new Connection().getGraph();
		edgeName = string;
		graph.createEdgeType(edgeName);
	}

	public void createEdge(String lastWord, String nextWord) {
		// TODO Auto-generated method stub
		AccessVertex vertex = new AccessVertex();
		vertex.getVertex(nextWord).addEdge(edgeName,vertex.getVertex(lastWord));
	}

}
