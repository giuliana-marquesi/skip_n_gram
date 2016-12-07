package bd;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class AccessVertex {
	
	private OrientGraph graph;
	private String vertexName;
	
	protected AccessVertex(){
		System.out.println("instanciou AccessEdge pelo AccesEdge");
	}

	public AccessVertex(String string) {
		// TODO Auto-generated constructor stub
		System.out.println("instanciou AccessVertex. Nome da classe: "+ string);
		
		graph = new Connection().getGraph();
		vertexName = string;
		graph.createVertexType(vertexName);
	}

	public void createVertex(String next) {
		// TODO Auto-generated method stub
		graph.addVertex("class:"+vertexName, "word", next);
		
	}
	
	protected Vertex getVertex(String string){
		for( Vertex v : graph.getVertices(vertexName+".name", string)) {
		    System.out.println("Found vertex: " + v);
		    return v;
		}
		
		return null;
		
	}

}
