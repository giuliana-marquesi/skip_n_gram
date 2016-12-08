package bd;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;


public class AccessEdge {
	
	private OrientGraph graph;
	private String edgeName;
	private Vertex next;
	private Vertex last;
	public AccessEdge(String string, OrientGraph db) {
		// TODO Auto-generated constructor stub
		graph = db;
		edgeName = string;
		try{
			graph.createEdgeType(edgeName);
			graph.commit();
		}catch (Exception e){
			graph.rollback();
		}
		//System.out.println("instanciou AccessEdge. Nome da classe: "+ string);
	}

	public void createEdge(String lastWord, String nextWord) {
		// TODO Auto-generated method stub
		System.out.println("comecou a criar arestas");
		AccessVertex vertex = new AccessVertex();
		last = vertex.getVertex(lastWord);
		System.out.println(last.getClass());
		next = vertex.getVertex(nextWord);
		System.out.println(next.getClass());
		try{
			last.addEdge(edgeName,next);
			graph.commit();
			System.out.println("Criou aresta");
		}catch (Exception e){
			graph.rollback();
		}
	}

}
