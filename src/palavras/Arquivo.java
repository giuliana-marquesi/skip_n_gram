package palavras;

import java.io.File;
import java.util.Scanner;

import controller.Manipulador;

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
			scanner = new Scanner(file).useDelimiter("[^\\p{javaDigit}\\p{javaLetter}]+");
			
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
}
