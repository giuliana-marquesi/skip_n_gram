package controller;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;

import bd.AccessEdge;
import bd.AccessVertex;

public class Manipulador {
	
	
	private String lastWord;
	private AccessEdge edge;
	private AccessVertex vertex;
	private OrientGraph db;
	
	public Manipulador(){
		try {
			db = new OrientGraph("remote:localhost:2424/s_n_g");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void includesInSequence(String next) {
		// TODO Auto-generated method stub
		
		if (lastWord == null){
			vertex = new AccessVertex("Sequence", db);
			//db.commit();
			edge = new AccessEdge("wordsInSequence", db);
			//db.commit();
			vertex.createVertex(next);
			lastWord = next;
			//db.commit();
			System.out.println("terminou no if");
		}else{
			try{
				//System.out.println("entrou no try do else");
				String nextWord = next;
				vertex.createVertex(nextWord);
				edge.createEdge(lastWord,nextWord);
				//db.commit();
				lastWord = nextWord;
				System.out.println("fez um ciclo de palavra");
			}catch(Exception e){
				System.out.println("deu errado!");
				db.rollback();
			}
		}
	}
	
	public void desligaAConexao(){
		db.shutdown();
	}
	
}
