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
		System.out.println("Palavra no manipulador sequence: " + next);
		
		if (lastWord == null){
			System.out.println("entrou no if");
			vertex = new AccessVertex("Sequence", db);
			System.out.println("voltou da instanciação do vértice");
			edge = new AccessEdge("wordsInSequence", db);
			
			vertex.createVertex(next);
			lastWord = next;
			System.out.println("commitou primeiro vertice. anterior");
			db.commit();
		}else{
			System.out.println("entrou no else");
			try{
				String nextWord = next;
				vertex.createVertex(nextWord);
				edge.createEdge(lastWord,nextWord);
				db.commit();
				lastWord = nextWord;
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
