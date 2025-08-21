package BlackJack;

import base.Condições_Do_Jogo;
import base.Jogadores;
import base.Mesa;

public class Condicionais_BlackJack extends Condições_Do_Jogo {// class

	Jogadores jogadores = new Jogadores();
	Mesa mesa = new Mesa();

	public void VerficacondicionalGanhou() {

		for (int count = 0; count < condicionalGanhou.length; count++) {

			if ((base.Jogadores.PontuaJogadores[count] <= 21)
					&& (base.Jogadores.PontuaJogadores[count] > base.Mesa.PontuacaoMesa)
					&& (base.Jogadores.PontuaJogadores[count] != base.Mesa.PontuacaoMesa))

			{

				condicionalGanhou[count] = true;

			}

		}

	}

	public void VerficacondicionalPerdeu() {

		for (int count = 0; count < condicionalPerdeu.length; count++) {

			if ((base.Jogadores.PontuaJogadores[count] > 21)
					|| (base.Jogadores.PontuaJogadores[count] < base.Mesa.PontuacaoMesa)
							&& (base.Jogadores.PontuaJogadores[count] != base.Mesa.PontuacaoMesa)
							&& base.Mesa.PontuacaoMesa <= 21)

			{

				condicionalPerdeu[count] = true;

			}

		}

	}

	public void VerficacondicionalEmpatou() {

		for (int count = 0; count < condicionalEmpate.length; count++) {

			if ((base.Jogadores.PontuaJogadores[count] <= 21) && (base.Mesa.PontuacaoMesa <= 21)
					&& (base.Jogadores.PontuaJogadores[count] == base.Mesa.PontuacaoMesa))

			{

				condicionalEmpate[count] = true;

			}

		}

	}

}// class
