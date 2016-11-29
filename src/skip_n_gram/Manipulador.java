package src.skip_n_gram;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Manipulador {
	
	private OrientGraph graph;
	private Connection conn;
	private Vertex verticeAnterior;
	
	public Manipulador(){
		conn = new Connection();
		graph = conn.getConnectedGraph();
		verticeAnterior = graph.addVertex(null);
	}

	public void verificaPoderIncluirNoBD(String next) {
		// TODO Auto-generated method stub
		if (verticeAnterior == null){
			verticeAnterior.setProperty(next, "palavra");
			graph.commit();
		}else{
			try{
				Vertex verticeProximo = graph.addVertex(null);
				verticeProximo.setProperty(next, "palavra");
				Edge palavrasLigadas = graph.addEdge(null, verticeAnterior, verticeProximo, "juntos");
				graph.commit();
				verticeAnterior = verticeProximo;
			}catch(Exception e){
				graph.rollback();
			}
		}
	}
	
	public void desligaAConexao(){
		conn.closeConnection();
	}
	
	

}
