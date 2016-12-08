package palavras;

import java.io.File;
import java.util.Scanner;

import controller.Manipulador;

public class Arquivo {
	
	File file;
	Scanner scanner;
	int controladorDePulos = 0;
	int controladorDeSelects = 0;
	int qtdPulos = 10;
	int qtdSelect = 1;
	int bla = 0;
	int meh = 0;
	int i = 0;
	
	public Arquivo(String nome){
		this.file = new File(nome);
	}
	
	private String cleaningWord(String palavra) {
		return palavra.replaceAll("[^\\p{javaDigit}\\p{javaLetter}]+", "");
	}
	
	private Boolean isWord(String palavra) {
		return palavra.length() > 0;
	}
	
	private void completouOsPulos() {
		if(controladorDePulos >= qtdPulos) {
			controladorDePulos = 0;
			controladorDeSelects = 0;
		}
	}
	
	private void fazerPulo() {
		controladorDePulos++;
		bla++;
	}
	
	private void seleciona() {
		controladorDeSelects++;
		meh++;
	}
	
	public void lerArquivo(){
		
		Manipulador manipulador = new Manipulador();
		System.out.println("foi no ler arquivo");
		
		try {
			// criar letrinhas: scanner = new Scanner(file).useDelimiter("[^\\p{javaDigit}\\p{javaLetter}]*");
			scanner = new Scanner(file);
			System.out.println("Scaniou");
			while(scanner.hasNext() ){
				i++;
				System.out.println("tem palavra");
				String cleanWord = cleaningWord(scanner.next());
				if(isWord(cleanWord)) {
					if(controladorDeSelects < qtdSelect) {
						seleciona();
						//manipulador.includesInSequence(cleanWord);
					} else {
						fazerPulo();
						completouOsPulos();
					}
				}
				
			}
			
		}catch(Exception e){
			System.out.println("dançou mano!");
			manipulador.desligaAConexao();
			
		}finally{
			if(scanner !=null){
				scanner.close();
			}
			System.out.println("i " + i);
			System.out.println("bla " + bla);
			System.out.println("meh " + meh);
		}
	}
}
