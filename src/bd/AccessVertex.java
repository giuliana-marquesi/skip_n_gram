package bd;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class AccessVertex {
	
	private OrientGraph graph;
	private String vertexName;
	
	protected AccessVertex(){
		//System.out.println("instanciou o da aresta");
	}

	public AccessVertex(String string, OrientGraph db) {
		// TODO Auto-generated constructor stub
		graph = db;
		vertexName = string;
		try{
			graph.createVertexType(vertexName);
			graph.commit();
		}catch (Exception e){
			graph.rollback();
		}
		//System.out.println("instanciou o accessvertex");
	}

	public void createVertex(String next) {
		// TODO Auto-generated method stub
		try{
			graph.addVertex("class:"+vertexName, "word", next);
			graph.commit();
			System.out.println("criou vértice");
		}catch (Exception e){
			graph.rollback();
		}
		
	}
	
	public Vertex getVertex(String string){
		System.out.println("entrou no getVertex");
		try{
			for(Vertex v : graph.getVertices("Sequence.word", string)) {
			    System.out.println("Found vertex: " + v);
			    return v;
			}
		}catch (Exception e){
			graph.rollback();
			System.out.println("nao deu no get Vertice");
		}
		return null;
	}

}
