package skip_n_gram;

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


