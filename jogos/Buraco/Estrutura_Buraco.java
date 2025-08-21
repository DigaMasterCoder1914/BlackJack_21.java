package Buraco;

import base.Jogadores;

public class Estrutura_Buraco {//class

	Jogadores_Buraco jogadores_Buraco = new  Jogadores_Buraco();
	Baralho_Buraco baralho_Buraco  = new Baralho_Buraco();
	
	
	public void jogo() {//metodo jogo()
		
		
		jogadores_Buraco.QuantosJogadores();
		jogadores_Buraco.TudoFalse();
		
		for(int count = 0;count < Jogadores.QuantJogadores ;count ++) {//for maior
		
			Jogadores.TurnoJogador[count] = true;
			
			for(int counte = 0;counte <= 11;counte ++) {//gera 11 cartas para cada jogador 
		
				
				baralho_Buraco.GerarUmaCarta();
				jogadores_Buraco.PreencheCartaGerada();
				jogadores_Buraco.Verificaturno();
				
			}//gera 11 cartas para cada jogador 
			
			Jogadores.TurnoJogador[count] = false ;
		}//for maior
		
	}//metodo jogo()
	
	
}//class
