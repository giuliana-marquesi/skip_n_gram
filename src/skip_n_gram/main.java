package src.skip_n_gram;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class main {

	public static void main(String args[]){

		ContadorDePalavras a = new ContadorDePalavras();
		//String nome = "/home/aluno/teste.txt";
		String nome = "../../miniWiki.txt";
		a.lerArquivo(nome);
		//a.mostrarQtd();
		System.out.println(a.qtdPalavrasUnicas());
	}

}


