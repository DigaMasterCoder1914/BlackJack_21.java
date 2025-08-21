package base;

import java.security.SecureRandom;

public class Baralho {

	
	
	
	protected static int CartasBaralho = 52;// cartas no baralho

	private static String[] Naipe = { "Ouros", "Espadas", "Copas", "Paus" };// naipe do baralho

	private int NaipeEscolhido;// armazena o naipe gerado
	protected static int CartaGerada;// armazena a carta gerada

	private static String[] cartaNome = { "Coringa", "Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove",
			"Dez", "Valete", "Dama", "Rei" };// armazena nome das cartas

	private boolean ContinuarGerando = false;// boolean de controle pra continuar o metodo SortearNaipe()
	private boolean GeraDenovo = false;// boolean pra loopar o meotodo GerarCarta()

	// boolean que trava a geração de cartas
	private boolean TravaGerarCartasOuros = false;
	private boolean TravaGerarCartasEspadas = false;
	private boolean TravaGerarCartasCopas = false;
	private boolean TravaGerarCartasPaus = false;

	// cartas tiradas de cada naipe
	private int CartasTiradasOuros = 0;
	private int CartasTiradasEspadas = 0;
	private int CartasTiradasCopas = 0;
	private int CartasTiradasPaus = 0;

	SecureRandom Sortear = new SecureRandom();// objeto SecureRandom

//verificar se tem carta restante nos naipes
	private boolean[] Ouros = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };
	private boolean[] Espadas = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };
	private boolean[] Copas = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };
	private boolean[] Paus = { true, true, true, true, true, true, true, true, true, true, true, true, true, true };

	// verifica se tem carta no naipe
	public void VerificaCartaNosNaipes() {

		for (int count = 1; count < Ouros.length; count++) {

			if (Ouros[count] == false) {

				CartasTiradasOuros++;

			}

			if (CartasTiradasOuros == 13)

				TravaGerarCartasOuros = true;

		}

		for (int count = 1; count < Paus.length; count++) {

			if (Paus[count] == false) {

				CartasTiradasPaus++;

			}

			if (CartasTiradasPaus == 13)

				TravaGerarCartasPaus = true;

		}

		for (int count = 1; count < Espadas.length; count++) {

			if (Espadas[count] == false) {

				CartasTiradasEspadas++;

			}

			if (CartasTiradasEspadas == 13)

				TravaGerarCartasEspadas = true;

		}

		for (int count = 1; count < Copas.length; count++) {

			if (Copas[count] == false) {

				CartasTiradasCopas++;

			}

			if (CartasTiradasCopas == 13)

				TravaGerarCartasCopas = true;

		}

	}

	// sorteia o naipe a ser gerado uma carta
	public void SortearNaipe() {

		do {

			if (CartasBaralho > 0) {

				NaipeEscolhido = Sortear.nextInt(4);

				switch (NaipeEscolhido) {
				case 0:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasOuros == true) {
						ContinuarGerando = true;
					} else {
						ContinuarGerando = false;

					}

					break;
				case 1:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasEspadas == true) {
						ContinuarGerando = true;
					} else {
						ContinuarGerando = false;

					}

					break;

				case 2:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasCopas == true) {
						ContinuarGerando = true;
					} else {
						ContinuarGerando = false;

					}

					break;
				case 3:
					VerificaCartaNosNaipes();
					if (TravaGerarCartasPaus == true) {
						ContinuarGerando = true;
					} else {
						ContinuarGerando = false;

					}

					break;

				}

			}

		} while (ContinuarGerando == true);

	}

	// gera uma carta aleatoria
	public void GerarCarta() {

		do {

			CartaGerada = 1 + Sortear.nextInt(13); // gera a carta aleatoria

			switch (NaipeEscolhido) {// elimina a carta tirada do naipe

			case 0:
				if (Ouros[CartaGerada] == true) {
					CartasBaralho--;
					Ouros[CartaGerada] = false;
					GeraDenovo = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo = true;

				}
				break;

			case 1:

				if (Espadas[CartaGerada] == true) {
					CartasBaralho--;
					Espadas[CartaGerada] = false;

					GeraDenovo = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo = true;

				}
				break;

			case 2:
				if (Copas[CartaGerada] == true) {
					CartasBaralho--;
					Copas[CartaGerada] = false;
					GeraDenovo = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo = true;

				}
				break;
			case 3:
				if (Paus[CartaGerada] == true) {
					CartasBaralho--;
					Paus[CartaGerada] = false;
					GeraDenovo = false;
					System.out.printf( "%s",RetornaCarta());
				} else {

					GeraDenovo = true;

				}
				break;

			}

		} while (GeraDenovo == true);

	}

	// retorna a carta
	public String RetornaCarta() {

		return String.format("Carta Gerada:\n %s de %s\n", cartaNome[CartaGerada], Naipe[NaipeEscolhido]);

	}

	// reseta o baralho e as booleans de controle
	public void resetBaralho() {

		

			
		
		TravaGerarCartasOuros = false;
		TravaGerarCartasEspadas = false;
		TravaGerarCartasCopas = false;
		TravaGerarCartasPaus = false;

		CartasTiradasOuros = 0;
		CartasTiradasEspadas = 0;
		CartasTiradasCopas = 0;
		CartasTiradasPaus = 0;

		CartasBaralho = 52;

		ResetaBoolean();

		
		
		
	}

	// reseta booleans de controle de cartas no naipe
	public void ResetaBoolean() {

		for (int count = 0; count < Ouros.length; count++) {

			Ouros[count] = true;
			Espadas[count] = true;
			Copas[count] = true;
			Paus[count] = true;

		}

	}

	// metodos retorna variaveis

	public static  int RetornarCartaGerada() {

		
		
		
		return CartaGerada;

	}

	
	//reseta CartaGerada
	public void ResetCartaGerada(){
		
		
		CartaGerada=0;
		
		
		
	}
	
	
	
	
}
