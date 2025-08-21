package BlackJack;

import base.Baralho;
import base.Jogadores;
import base.Condições_Do_Jogo;
import base.Mesa;

import java.util.Scanner;

public class Estrutura_BlackJack_21 extends Jogadores {

//objetos das classes 	
	Baralho baralho = new Baralho();

	Jogadores jogadores = new Jogadores();

	Condições_Do_Jogo condições_Do_Jogo = new Condições_Do_Jogo();

	Mesa mesa = new Mesa();

	Condicionais_BlackJack Condicoes = new Condicionais_BlackJack();

	Baralho_BlackJack baralho_21 = new Baralho_BlackJack();
	// objetos das classes

	boolean LoopJogarDenovo = false;// controla loop de jogar denovo
	Scanner recebeLoopJogarDenovo = new Scanner(System.in);// obejto Scanner
	String recebeRespostaLoopJogarDenovo;// String que armazena resposta do jogador se quer jogar denovo

	// variaveis de controle do loop do metodo RodadasInfinitas()
	String RespostaJogadorLoop;
	Scanner recebe = new Scanner(System.in);
	String Loop_Resposta;
	Scanner LoopResposta = new Scanner(System.in);

	int[] jogs;// array jogs

	public void PrimeiraRodada() {// primeira rodada jogadores

		jogadores.QuantosJogadores();

		jogs = new int[QuantJogadores];

		for (int count = 0; count < jogs.length; count++) {

			jogadores.PerguntaJogadores();
		}

		for (int count = 0; count < jogs.length; count++) {

			baralho.SortearNaipe();

			if (QuerCarta[count] == true) {

				baralho.GerarCarta();
			}
		

			baralho_21.CorrigeValorCartaGerada();
			baralho_21.verificaAs();
			
			jogadores.Verificaturno();

			jogadores.PreencheCartaGerada();

			QuerCarta[count] = false;// encerra turno do jogador

			jogadores.Verificaturno();

		}

		jogadores.exibiPontuações();

	}

	public void RodadasInfinitas() {// rodadas infinitas

		System.out.print(
				"Agora começaremos a perguntar individualmente se os jogadores querem puxar mais uma carta em seus turnos!\n");

		for (int count = 0; count < jogs.length; count++) {// for

			if (JogaEssaRodada[count] == true) {// if maior

				System.out.printf("%s voce deseja puxar mais uma carta?", Jogadores[count]);
				RespostaJogadorLoop = recebe.next();

				if (RespostaJogadorLoop.equalsIgnoreCase("SIM")) {// if

					QuerCarta[count] = true;

					// loop de gerar carta
					do {// do

						baralho.GerarCarta();

						
						baralho_21.CorrigeValorCartaGerada();
						baralho_21.verificaAs();
						jogadores.Verificaturno();
						jogadores.PreencheCartaGerada();
						System.out.printf("%s deseja puxar mais uma carta?\n", Jogadores[count]);
						Loop_Resposta = LoopResposta.next();

					} while (Loop_Resposta.equalsIgnoreCase("SIM"));// while

					QuerCarta[count] = false;// fim do turno
					baralho_21.Logica_As();
				} // if
				else {// else

					QuerCarta[count] = false;
					baralho_21.Logica_As();

				} // else

			} // if maior

		} // for

	}// rodadas infinitas

	public void primeiraRodadaMesa() {// primeira rodada mesa

		System.out.print("A mesa agora revela a carta que tirou!\n");
		baralho.GerarCarta();
		baralho_21.CorrigeValorCartaGerada();
		mesa.MesaQuerCarta();
		mesa.PontuarMesa();
		mesa.ExibirPontuacaoMesa();

	}

	public void RodadasExtraMesa() {// rodadas extras da mesa

		do {

			System.out.print("A mesa agora revela a carta que tirou!\n");
			baralho.GerarCarta();
			baralho_21.CorrigeValorCartaGerada();
			mesa.MesaQuerCarta();
			mesa.PontuarMesa();
			mesa.ExibirPontuacaoMesa();

		} while (mesa.RetornaPontuacaoMesa() <= 16);

	}

	public void QuerJogarDenovo() {

		System.out.print("Deseja jogar denovo?");
		recebeRespostaLoopJogarDenovo = recebeLoopJogarDenovo.next();

		if (recebeRespostaLoopJogarDenovo.equalsIgnoreCase("Sim")) {

			LoopJogarDenovo = true;
		}

		else {

			LoopJogarDenovo = false;

		}

	}

	public void jogo() {// thread do jogo rodando

		do {

			PrimeiraRodada();
			primeiraRodadaMesa();
			RodadasInfinitas();
			RodadasExtraMesa();
			condições_Do_Jogo.setaTamanhoArrays();
			Condicoes.VerficacondicionalEmpatou();
			Condicoes.VerficacondicionalGanhou();
			Condicoes.VerficacondicionalPerdeu();
			condições_Do_Jogo.DefineEmpate();
			condições_Do_Jogo.DefinePerdedor();
			condições_Do_Jogo.DefineVencedor();
			baralho_21.resetBaralho();
			jogadores.resetaJogadores();
			mesa.ResetPontuacaoMesa();

			QuerJogarDenovo();

		} while (LoopJogarDenovo == true);

	}

}
