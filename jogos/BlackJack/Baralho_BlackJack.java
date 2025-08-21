package BlackJack;

import base.Baralho;
import base.Jogadores;

public class Baralho_BlackJack extends Baralho {

	Jogadores jogs = new Jogadores();

	private static int[] jogadorTirouAs;

	public void CorrigeValorCartaGerada() {

		if (Baralho.CartaGerada > 10) {

			Baralho.CartaGerada = 10;// corrige problema do valete,rei e rainha darem pontuação 11,12,13

		}

	}

public void verificaAs() {//metodo que verifica se tirou ÁS
		
		
		
		jogadorTirouAs = new int[Jogadores.QuantJogadores];// defini tamanho do array para QuantJogadores

		for (int count = 0; count < Jogadores.QuantJogadores; count++) {// for

			if (Baralho.CartaGerada == 1) {// if

				Baralho.CartaGerada = 11;

				jogadorTirouAs[count] += 1;// incrementa em um a quantidade de As tirados do jogador
			} // if

		} // for
		
		
	}//metodo que verifica se tirou ÁS
	
	public void Logica_As() {// logica do ÁS

		
		for(int count =0;count < jogadorTirouAs.length ;count ++ ) {//for
		
		do {//do
			
			
			if(jogadorTirouAs[count] >= 1 &&  Jogadores.PontuaJogadores[count]  > 21 ) {//se pontuação do jogador for maior que 21 e o jogador tirou ás
				
				Jogadores.PontuaJogadores[count] -= 10;
				jogadorTirouAs[count] -= 1;
				
				
			}//se pontuação do jogador for maior que 21 e o jogador tirou ás
			
			
			
			
			
			
			
		}while(jogadorTirouAs[count] !=  0);//while
		
		
		
		}//for

	}// logica do ÁS

	
	
	
	
	@Override public void resetBaralho() {
		
		
		if(Baralho.CartasBaralho <10) {
			
			
			
			
			super.resetBaralho();
			
			
		}
		
		
		
		
		
	}
	
	
	
	
}


