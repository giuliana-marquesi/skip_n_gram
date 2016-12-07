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
	
	private String cleaningWord(String palavra) {
		return palavra.replaceAll("[^\\p{javaDigit}\\p{javaLetter}]+", "");
	}
	
	private Boolean isWord(String palavra) {
		return palavra.length() > 0;
	}
	
	public void lerArquivo(){
		
		Manipulador manipulador = new Manipulador();
		System.out.println("foi no ler arquivo");
		
		try {
			scanner = new Scanner(file);
			
			System.out.println("Scaniou");
			while(scanner.hasNext() ){
				System.out.println("tem palavra");
				String cleanWord = cleaningWord(scanner.next());
				if(isWord(cleanWord)) {
					manipulador.includesInSequence(cleanWord);
				}				
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
