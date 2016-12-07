package skip_n_gram;

import palavras.Arquivo;

public class main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main");
		String nome = "miniWiki.txt";
		Arquivo arq = new Arquivo(nome);
		arq.lerArquivo();
	}

}