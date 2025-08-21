package Buraco;

import base.Baralho;
import base.Jogadores;
import java.util.ArrayList;

import java.util.Scanner;

public class Jogadores_Buraco extends Jogadores {

	ArrayList<Integer>[] CartaGeradaNumero;// armazena no array o numero da carta gerada

	private int[] cartasGeradas = new int[4];// armazena no array para o numero de cartas geradas por jogador

	public void PreencheArray() {

		CartaGeradaNumero[0] = new ArrayList<Integer>();
		CartaGeradaNumero[1] = new ArrayList<Integer>();
		CartaGeradaNumero[2] = new ArrayList<Integer>();
		CartaGeradaNumero[3] = new ArrayList<Integer>();

	}

	Baralho_Buraco baralho_Buraco = new Baralho_Buraco();
	Baralho baralho = new Baralho();
	Scanner Recebe = new Scanner(System.in);
	String Nome;

	boolean QuantosJogadoresDenovo = false;// boolean pra loopar o meotodo QuantosJogadores()

	@Override
	public void QuantosJogadores() {// seta quantidade de Jogadores e define os nomes deles

		do {

			try {
				System.out.print("Quantos jogadores na mesa?");
				QuantJogadores = Recebe.nextInt();

				switch (QuantJogadores) {
				case 2:
					// seta os arrays para terem o mesmo tamanho que Quantidade de Jogadores
					Jogadores = new String[QuantJogadores];
					PontuaJogadores = new int[QuantJogadores];
					TurnoJogador = new boolean[QuantJogadores];
					QuerCarta = new boolean[QuantJogadores];
					JogaEssaRodada = new boolean[QuantJogadores];
					QuantosJogadoresDenovo = false;
					break;
				case 4:
					Jogadores = new String[QuantJogadores];
					PontuaJogadores = new int[QuantJogadores];
					TurnoJogador = new boolean[QuantJogadores];
					QuerCarta = new boolean[QuantJogadores];
					JogaEssaRodada = new boolean[QuantJogadores];
					QuantosJogadoresDenovo = false;
					break;
				default:
					QuantosJogadoresDenovo = true;
					throw new IllegalArgumentException("O jogo só aceita 2 ou 4 jogadores!");

				}

			} catch (IllegalArgumentException e) {

				StackTraceElement[] d = e.getStackTrace();

				for (StackTraceElement f : d) {

					System.out.printf("%s", f.getClassName());
					System.out.printf("%s", f.getClass());
					System.out.printf("%s", f.getMethodName());
					System.out.printf("%d", f.getLineNumber());

				}

			}

		} while (QuantosJogadoresDenovo == true);

//preenche nome dos jogadores no array Jogadores
		for (int count = 0; count < Jogadores.length; count++) {

			System.out.printf("Qual seu nome jogador %d?", count);
			Nome = Recebe.next();

			Jogadores[count] = Nome;

		}

	}

	@Override
	public void PreencheCartaGerada() {// coloca a carta gerada na mão do jogador

		for (int count = 0; count < QuantJogadores; count++) {

			if (TurnoJogador[count] == true) {

				CartaGeradaNumero[count].add(Baralho.RetornarCartaGerada());// passa a carta gerada pra mão do jogador
				CartaGeradaNumero[count].add(Baralho_Buraco.RetornarCartaGerada2());// passa a carta gerada pra mão do
																					// jogador

				cartasGeradas[count] += 1;// contando quantas cartas foram geradas para o jogador

				baralho.ResetCartaGerada();
				baralho_Buraco.ResetCartaGerada2();

			} else {

			}

		}

	}

	@Override public void  Verificaturno() {//metodo verifica turno
		
		
		
	super.Verificaturno();
	
	
	for(int count = 0;count < 4;count ++) {//for
	
	if(cartasGeradas[count] == 11) {//if
		
		TurnoJogador[count] = false;
		
	}//if
		
		
	}//for
	
		
	}// metodo verifica turno
	
	
	public void TudoFalse() {//todos os turnos como false
		
		
		
		for(int count =0;count < QuantJogadores;count++) {
			
			
			TurnoJogador[count] = false;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
