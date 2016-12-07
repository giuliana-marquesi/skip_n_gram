package controller;

import bd.AccessEdge;
import bd.AccessVertex;
import bd.Connection;

public class Manipulador {
	
	
	private String lastWord;
	private AccessEdge edge;
	private AccessVertex vertex;
	private OrientGraph db;
	
	public Manipulador(){
		try{
			conn = new Connection();
			conn.connectGraph();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("deu ruim na conexao");
		}
	}

	public void includesInSequence(String next) {
		// TODO Auto-generated method stub
		System.out.println("Palavra no manipulador sequence: " + next);
		
		if (lastWord == null){
			System.out.println("entrou no if");
			vertex = new AccessVertex("Sequence", conn);
			System.out.println("voltou da instanciação do vértice");
			edge = new AccessEdge("wordsInSequence", conn);
			
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
