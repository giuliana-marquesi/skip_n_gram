package skip_n_gram;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class ContadorDePalavras {
	private HashMap<String, Integer> estatistica;
	Connection conn = new Connection();
	OrientGraph graph = conn.getConnectedGraph();
	Vertex lastWord;
	Vertex nextWord;
	
	public ContadorDePalavras(){
		estatistica = new HashMap<String, Integer>();
	}
	 
	
	public void lerArquivo(String nome){
		File file = new File(nome);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			int i = 0;
			while( scanner.hasNext() ){
				System.out.println(i++);
				atualizarDicionario(scanner.next());
			}
			graph.commit();
			graph.shutdown();			
		}catch(Exception e){
			System.out.println("dançou mano!");
			
		}finally{
			if(scanner !=null){
				scanner.close();
			}
		}
	}
	
	private void atualizarDicionario(String str) {
		//String labelForEdge = this.lastWord.getProperty("word") + "--" + str;
		
		try {
			this.nextWord = graph.addVertex(null);
			this.nextWord.setProperty("word", str);
			
			//Edge lastWord_newWord = graph.addEdge(null, this.lastWord, this.nextWord, "arestra");
			
			//this.lastWord = this.nextWord;
			
			
		} catch (Exception e) {
			graph.rollback();
		}
	}
	
	public int qtdPalavrasUnicas(){
		return estatistica.size();
	}

	public void mostrarQtd() {
		for (String key: estatistica.keySet()) {
		    System.out.println("key : " + key);
		    System.out.println("value : " + estatistica.get(key));
		}
	}
}
