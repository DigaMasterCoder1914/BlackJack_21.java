package base;



public class Condições_Do_Jogo {

	int Jogadores = 0;// variavel para armazenar QuantJogadores

	// arrrays pra empate,vitoria ou derrota dos jogadores
	private static boolean[] JogadorEmpate;
	private static boolean[] JogadorPerdeu;
	private static boolean[] JogadorGanhou;

	protected static boolean[] condicionalEmpate;
	protected static boolean[] condicionalPerdeu;
	protected static boolean[] condicionalGanhou;

	Jogadores jogadores = new Jogadores();// obejto da classe Jogadores

	public void setaTamanhoArrays() {

		Jogadores = jogadores.ReturnQuantJogadores();// atribui o valor de QuantJogadores a jogadores

		// seta tamanho dos arrays
		JogadorEmpate = new boolean[Jogadores];
		JogadorPerdeu = new boolean[Jogadores];
		JogadorGanhou = new boolean[Jogadores];

		condicionalEmpate = new boolean[Jogadores];
		condicionalPerdeu = new boolean[Jogadores];
		condicionalGanhou = new boolean[Jogadores];

	}

	// define se ganhou
	public void DefineVencedor() {

		for (int count = 0; count < JogadorGanhou.length; count++) {

			if (condicionalGanhou[count] == true) {

				JogadorGanhou[count] = true;
				System.out.printf("%s voce ganhou o jogo com a pontuação de  %d pontos\n ",
						base.Jogadores.Jogadores[count], base.Jogadores.PontuaJogadores[count]);
			} else {

				JogadorGanhou[count] = false;

			}

		}

	}

	// define se empatou
	public void DefineEmpate() {

		for (int count = 0; count < JogadorEmpate.length; count++) {

			if (condicionalEmpate[count] == true) {

				JogadorEmpate[count] = true;
				System.out.printf("%s voce empatou  o jogo com a mesa com a  pontuação de  %d pontos\n ",
						base.Jogadores.Jogadores[count], base.Jogadores.PontuaJogadores[count]);

			} else {

				JogadorEmpate[count] = false;

			}

		}

	}

	// define se perdeu
	public void DefinePerdedor() {

		for (int count = 0; count < JogadorPerdeu.length; count++) {

			if (condicionalPerdeu[count] == true) {

				JogadorPerdeu[count] = true;
				System.out.printf("%s voce perdeu o jogo com a pontuação de  %d pontos\n ",
						base.Jogadores.Jogadores[count], base.Jogadores.PontuaJogadores[count]);

			} else {

				JogadorPerdeu[count] = false;

			}

		}

	}

//reseta variaveis 
	public void resetaTudo() {

		for (int count = 0; count < JogadorEmpate.length; count++) {

			JogadorEmpate[count] = false;
			JogadorPerdeu[count] = false;
			JogadorGanhou[count] = false;

			condicionalEmpate[count] = false;
			condicionalPerdeu[count] = false;
			condicionalGanhou[count] = false;

		}

	}

}