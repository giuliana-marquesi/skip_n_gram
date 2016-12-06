package skip_n_gram;

import java.io.File;
import java.util.Scanner;

public class Arquivo {
	
	File file;
	Scanner scanner;
	
	public Arquivo(String nome){
		this.file = new File(nome);
	}
	
	public void lerArquivo(){
		
		Manipulador manipulador = new Manipulador();
		System.out.println("foi no ler arquivo");
		
		try {
			scanner = new Scanner(file);
			System.out.println("Scaniou");
			while(scanner.hasNext() ){
				manipulador.verificaPoderIncluirNoBD(scanner.next());
				System.out.println(scanner.next());
			}
			
		}catch(Exception e){
			System.out.println("dançou mano!");
			manipulador.desligaAConexao();
			
		}finally{
			if(scanner !=null){
				scanner.close();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome = "miniWiki.txt";
		Arquivo arq = new Arquivo(nome);
		arq.lerArquivo();
	}
}
