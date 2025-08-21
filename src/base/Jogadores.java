package base;

import java.util.Scanner;//import Scanner



public class Jogadores {

	Scanner Recebe = new Scanner(System.in);// objeto Scanner
	public static int QuantJogadores;// quantidade de jogadores
	private static String Nome;// nome

	Baralho baralho = new Baralho();// objetoBaralho
	
	
	
	public static int[] PontuaJogadores;// carta gerada de cada jogador

	protected static boolean[] JogaEssaRodada;// jogador joga essa rodada

	public static boolean[] TurnoJogador;// turno de cada jogador

	protected static boolean[] QuerCarta;// jogador quer carta

	public static String[] Jogadores;// array Jogadores

	public void QuantosJogadores() {// seta quantidade de Jogadores e define os nomes deles

		System.out.print("Quantos jogadores na mesa?");
		QuantJogadores = Recebe.nextInt();

		// seta os arrays para terem o mesmo tamanho que Quantidade de Jogadores
		Jogadores = new String[QuantJogadores];
		PontuaJogadores = new int[QuantJogadores];
		TurnoJogador = new boolean[QuantJogadores];
		QuerCarta = new boolean[QuantJogadores];
		JogaEssaRodada = new boolean[QuantJogadores];

//preenche nome dos jogadores no array Jogadores
		for (int count = 0; count < Jogadores.length; count++) {

			System.out.printf("Qual seu nome jogador %d?", count);
			Nome = Recebe.next();

			Jogadores[count] = Nome;

		}

	}

//verifica se é o turno do jogador 
	public void Verificaturno() {

		for (int count = 0; count < QuantJogadores; count++) {

			if (QuerCarta[count] == true) {

				TurnoJogador[count] = true;

			} else {

				TurnoJogador[count] = false;

			}

		}

	}

	// adiciona carta gerada a pontuação do jogador
	public void PreencheCartaGerada() {

		for (int count = 0; count < QuantJogadores; count++) {

			if (TurnoJogador[count] == true) {

				PontuaJogadores[count] += Baralho.RetornarCartaGerada();
				
					
					
					
					
			
				baralho.ResetCartaGerada();
				System.out.printf("%s a sua pontuação é de %d!\n", Jogadores[count], PontuaJogadores[count]);

			} else {

			}

		}

	}

	private static int Contador = 0;
	private boolean PerguntaControle = true;// boolean controle do loop PerguntaJogadores()
	private String Resposta = "";// string com a resposta do usuario
	Scanner RecebeResposta = new Scanner(System.in);// obejto Scanner


	// pergunta se o jogador quer carta
	public void PerguntaJogadores() {

		System.out.printf("   %s Voce deseja jogar essa rodada?\n", Jogadores[Contador]);
		Resposta = RecebeResposta.next();

		if (Resposta.equalsIgnoreCase("Sim")) {

			QuerCarta[Contador] = true;
			JogaEssaRodada[Contador] = true;
			PerguntaControle = false;

			System.out.printf("  %s iremos puxar uma carta para voce!\n", Jogadores[Contador]);
			Contador++;
			ResetaContador();

		}
		if (!Resposta.equalsIgnoreCase("Sim")) {
			QuerCarta[Contador] = false;
			JogaEssaRodada[Contador] = false;
			PerguntaControle = true;

			System.out.printf("Que pena %s,nos vemos na proxima então!\n", Jogadores[Contador]);
			Contador++;
			ResetaContador();
		}

	}

	// reseta contador de PerguntaJogadores()
	public void ResetaContador() {

		if (Contador == QuantJogadores) {

			Contador = 0;
		}

	}

	// retorna a variavel static QuantJogadores
	public int ReturnQuantJogadores() {

		return QuantJogadores;

	}

	// exibir pontuações dos jogadores
	public void exibiPontuações() {

		System.out.println("A primeira rodada do jogo ficou assim:\n");

		for (int count = 0; count < QuantJogadores; count++) {

			System.out.printf("%s com %d pontos\n", Jogadores[count], PontuaJogadores[count]);

		}
	}

	

	public void resetaJogadores() {
		
		
		for(int count = 0;count < QuantJogadores ; count ++) {
			
			PontuaJogadores[count] = 0;
			TurnoJogador[count] = false;
			QuerCarta[count] = false;
			JogaEssaRodada[count] = false;
			
			
			
		}
		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
