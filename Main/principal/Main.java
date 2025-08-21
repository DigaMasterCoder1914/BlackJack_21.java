package principal;

import BlackJack.Estrutura_BlackJack_21;
import Buraco.Estrutura_Buraco;
import java.util.Scanner;

public class Main {
	
public static void main(String[]args) {
	
	
	
	Estrutura_BlackJack_21 b = new Estrutura_BlackJack_21();
	Estrutura_Buraco a = new  Estrutura_Buraco();
	
	Scanner  resposta = new Scanner(System.in);
	String jogo;
	
	boolean perguntadenovo = false;
	
	
	System.out.print("Bem vindo a nosso simulador de Cassino!\n");
	System.out.print("Estamos na versão beta,temos Buraco e BlackJack!\n");
	System.out.print("Qual jogo deseja jogar?\n");
	jogo =resposta.next();
	
	
	do {
	
		try {
		
	switch(jogo) {
	
	case "Buraco":
	case "BURACO":
	case "buraco":	
		a.jogo();
	perguntadenovo = false;
	break;
	case "BlackJack":
	case "blackjack":
		b.jogo();
		perguntadenovo = false;
	break;
	default:
		throw new IllegalArgumentException("Jogo invalido!");
	
	
	}
		}catch(IllegalArgumentException e) {
			
			
StackTraceElement[] d = e.getStackTrace();
			
			for(StackTraceElement f : d) {
				
				System.out.printf("%s",f.getClassName());
				System.out.printf("%s",f.getClass());
				System.out.printf("%s",f.getMethodName());
				System.out.printf("%d",f.getLineNumber());
				
			}
			
			
			
		}
		
	}while(perguntadenovo == true);
}
}
