package controller;

import bd.AccessEdge;
import bd.AccessVertex;
import bd.Connection;

public class Manipulador {
	
	
	private String lastWord;
	private AccessEdge edge;
	private AccessVertex vertex;
	private Connection conn;
	
	public Manipulador(){
		conn = new Connection();
		conn.connectGraph();
	}

	public void includesInSequence(String next) {
		// TODO Auto-generated method stub
		System.out.println("Palavra no manipulador sequence: " + next);
		
		if (lastWord == null){
			System.out.println("entrou no if");
			vertex = new AccessVertex("Sequence");
			System.out.println("voltou da instanciação do vértice");
			edge = new AccessEdge("wordsInSequence");
			
			vertex.createVertex(next);
			lastWord = next;
			System.out.println("commitou primeiro vertice. anterior");
			conn.commit();
		}else{
			System.out.println("entrou no else");
			try{
				String nextWord = next;
				vertex.createVertex(nextWord);
				edge.createEdge(lastWord,nextWord);
				conn.commit();
				lastWord = nextWord;
			}catch(Exception e){
				System.out.println("deu errado!");
				conn.rollback();
			}
		}
	}
	
	public void desligaAConexao(){
		conn.closeConnection();
	}
	
	

}
