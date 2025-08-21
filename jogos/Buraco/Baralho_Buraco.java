package Buraco;

import java.security.SecureRandom;

import base.Baralho;

import java.util.Scanner;



public class Baralho_Buraco extends Baralho {//class

	
	
	Scanner sorteiaBaralho = new Scanner(System.in);//objeto Scanner
	private int baralhoEscolhido; 
	

	//cria outro baralho
	
	protected static int CartasBaralho2 = 52;// cartas no baralho

private static String[] Naipe2 = { "Ouros", "Espadas", "Copas", "Paus" };// naipe do baralho

	private int NaipeEscolhido2;// armazena o naipe gerado
	protected static int CartaGerada2;// armazena a carta gerada

	private static String[] cartaNome2 = { "Coringa", "Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove",
			"Dez", "Valete", "Dama", "Rei" };// armazena nome das cartas

	private boolean ContinuarGerando2 = false;// boolean de controle pra continuar o metodo SortearNaipe()
	private boolean GeraDenovo2 = false;// boolean pra loopar o meotodo GerarCarta()
	private boolean GeraDenovo_2 = false;// boolean pra loopar o meotodo GerarUmaCarta()
	
	protected boolean GerouCarta1 = false;// boolean pra verificar se gerou carta do baralho 1
	protected boolean GerouCarta2 = false;// boolean pra verificar se gerou carta do baralho 2
	
	
	// boolean que trava a geração de cartas
	private boolean TravaGerarCartasOuros2 = false;
	private boolean TravaGerarCartasEspadas2 = false;
	private boolean TravaGerarCartasCopas2 = false;
	private boolean TravaGerarCartasPaus2 = false;

	// cartas tiradas de cada naipe
	private int CartasTiradasOuros2 = 0;
	private int CartasTiradasEspadas2 = 0;
	private int CartasTiradasCopas2 = 0;
	private int CartasTiradasPaus2 = 0;

	SecureRandom Sortear2 = new SecureRandom();// objeto SecureRandom

//verificar se tem carta restante nos naipes
	private boolean[] Ouros2 = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };
	private boolean[] Espadas2 = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };
	private boolean[] Copas2 = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };
	private boolean[] Paus2 = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };

	// verifica se tem carta no naipe
	public void VerificaCartaNosNaipes2() {

		for (int count = 1; count < Ouros2.length; count++) {

			if (Ouros2[count] == false) {

				CartasTiradasOuros2++;

			}

			if (CartasTiradasOuros2 == 13)

				TravaGerarCartasOuros2 = true;

		}

		for (int count = 1; count < Paus2.length; count++) {

			if (Paus2[count] == false) {

				CartasTiradasPaus2++;

			}

			if (CartasTiradasPaus2 == 13)

				TravaGerarCartasPaus2 = true;

		}

		for (int count = 1; count < Espadas2.length; count++) {

			if (Espadas2[count] == false) {

				CartasTiradasEspadas2++;

			}

			if (CartasTiradasEspadas2 == 13)

				TravaGerarCartasEspadas2 = true;

		}

		for (int count = 1; count < Copas2.length; count++) {

			if (Copas2[count] == false) {

				CartasTiradasCopas2++;

			}

			if (CartasTiradasCopas2 == 13)

				TravaGerarCartasCopas2 = true;

		}

	}

	// sorteia o naipe a ser gerado uma carta
	public void SortearNaipe2() {

		do {

			if (CartasBaralho2 > 0) {

				NaipeEscolhido2 = Sortear2.nextInt(4);

				switch (NaipeEscolhido2) {
				case 0:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasOuros2 == true) {
						ContinuarGerando2 = true;
					} else {
						ContinuarGerando2 = false;

					}

					break;
				case 1:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasEspadas2 == true) {
						ContinuarGerando2 = true;
					} else {
						ContinuarGerando2 = false;

					}

					break;

				case 2:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasCopas2 == true) {
						ContinuarGerando2 = true;
					} else {
						ContinuarGerando2 = false;

					}

					break;
				case 3:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasPaus2 == true) {
						ContinuarGerando2 = true;
					} else {
						ContinuarGerando2 = false;

					}

					break;

				}

			}

		} while (ContinuarGerando2 == true);

	}

	// gera uma carta aleatoria
	 public void GerarCarta2() {

		do {

			CartaGerada2 = 1 + Sortear2.nextInt(13); // gera a carta aleatoria

			switch (NaipeEscolhido2) {// elimina a carta tirada do naipe

			case 0:
				if (Ouros2[CartaGerada2] == true) {
					CartasBaralho2--;
					Ouros2[CartaGerada2] = false;
					GeraDenovo2 = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo2 = true;

				}
				break;

			case 1:

				if (Espadas2[CartaGerada2] == true) {
					CartasBaralho2--;
					Espadas2[CartaGerada2] = false;

					GeraDenovo2 = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo2 = true;

				}
				break;

			case 2:
				if (Copas2[CartaGerada2] == true) {
					CartasBaralho2--;
					Copas2[CartaGerada2] = false;
					GeraDenovo2 = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo2 = true;

				}
				break;
			case 3:
				if (Paus2[CartaGerada2] == true) {
					CartasBaralho2--;
					Paus2[CartaGerada2] = false;
					GeraDenovo2 = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo2 = true;

				}
				break;

			}

		} while (GeraDenovo2 == true);

	}

	// retorna a carta
	public String RetornaCarta2() {

		return String.format("Carta Gerada:\n %s de %s\n", cartaNome2[CartaGerada2], Naipe2[NaipeEscolhido2]);

	}

	// reseta o baralho e as booleans de controle
	public void resetBaralho2() {

		

			
		
		TravaGerarCartasOuros2 = false;
		TravaGerarCartasEspadas2 = false;
		TravaGerarCartasCopas2 = false;
		TravaGerarCartasPaus2 = false;

		CartasTiradasOuros2 = 0;
		CartasTiradasEspadas2 = 0;
		CartasTiradasCopas2 = 0;
		CartasTiradasPaus2 = 0;

		CartasBaralho2 = 52;

		ResetaBoolean();

		
		
		
	}

	// reseta booleans de controle de cartas no naipe
	public void ResetaBoolean2() {

		for (int count = 0; count < Ouros2.length; count++) {

			Ouros2[count] = true;
			Espadas2[count] = true;
			Copas2[count] = true;
			Paus2[count] = true;

		}

	}

	// metodos retorna variaveis

	public static  int RetornarCartaGerada2() {

		
		
		
		return CartaGerada2;

	}

	
	//reseta CartaGerada
	public void ResetCartaGerada2(){
		
		
		CartaGerada2=0;
		
		
		
	}
	
	//cria outro baralho
	

		public void GerarUmaCarta(){//altera a lógica de gerar uma carta escolhendo entre os dois baralhos
			
			do {
			
			baralhoEscolhido = sorteiaBaralho.nextInt(1);
			switch(baralhoEscolhido) {//switch
			
			case 0:
				
				if( CartasBaralho2 > 0) {
				
					SortearNaipe2();
				GerarCarta2();
				RetornarCartaGerada2();
				GeraDenovo_2 = false;
				GerouCarta2 = true;
				
				}else {
					
					GeraDenovo_2 = true;
					GerouCarta2 = false;
					
				}
				break;
			case 1:
				
				if( CartasBaralho > 0) {
				
					SortearNaipe();
				GerarCarta();
				RetornarCartaGerada();
				GeraDenovo_2 = false;
				GerouCarta1 = true;
				}else {
					
					GeraDenovo_2 = true;
					GerouCarta1 = false;
					
				}
				break;
			
			}//switch
			
			
		}while(GeraDenovo_2 = true);//while
	
	
	
	
		}//altera a lógica de gerar uma carta escolhendo entre os dois baralhos
		

		
      
	

		
		
		
	}//class


	
	
	
	

