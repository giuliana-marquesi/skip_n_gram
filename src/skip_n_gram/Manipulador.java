package skip_n_gram;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Manipulador {
	
	private OrientGraph graph;
	private Connection conn;
	private Vertex lastWord;
	
	public Manipulador(){
		conn = new Connection();
		graph = conn.getConnectedGraph();
		lastWord = graph.addVertex(null);
		System.out.println("Last word ID init: " + lastWord.getId());
	}

	public void verificaPoderIncluirNoBD(String next) {
		// TODO Auto-generated method stub
		System.out.println(next);
		if (lastWord == null){
			lastWord.setProperty("word", next);
			System.out.println("commitou primeiro vertice. anterior");
			graph.commit();
		}else{
			System.out.println("entrou no else");
			try{
				Vertex nextWord = graph.addVertex(null);
				nextWord.setProperty("word", next);
				System.out.println("Created vertex: " + nextWord.getProperty("word"));
				Edge lastWord_newWord = graph.addEdge(null, lastWord, nextWord, "juntos");
				System.out.println("Created Edge: " + lastWord_newWord.getId());
				graph.commit();
				lastWord = nextWord;
				System.out.println("Copy vertex: " + lastWord.getProperty("word"));
			}catch(Exception e){
				graph.rollback();
			}
		}
	}
	
	public void desligaAConexao(){
		conn.closeConnection();
	}
	
	

}
