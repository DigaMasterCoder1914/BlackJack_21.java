
package base;

public class Mesa {

	private static boolean MesaQuerCarta = false;
	public static int PontuacaoMesa = 0;
	private static boolean MesaEmpata = false;
	private static boolean MesaGanha = false;
	private static boolean MesaPerde = false;

	protected static boolean condicionalMesaGanha = false;
	protected static boolean condicionalMesaEmpata = false;
	protected static boolean condicionalMesaPerde = false;

	public void MesaQuerCarta() {

		MesaQuerCarta = true;

	}

	public void ResetMesaQuerCarta() {

		MesaQuerCarta = false;

	}

	public void ResetPontuacaoMesa() {

		PontuacaoMesa = 0;

	}

	public void PontuarMesa() {

		if (MesaQuerCarta == true) {

			PontuacaoMesa += Baralho.RetornarCartaGerada();

		}

	}

	public void VerificaMesaGanha() {

		if (condicionalMesaGanha == true) {

			MesaGanha = true;

		}

	}

	public void VerificaMesaPerde() {

		if (condicionalMesaPerde == true) {

			MesaPerde = true;

		}

	}

	public void VerificaMesaEmpate() {

		if (condicionalMesaEmpata == true) {

			MesaEmpata = true;

		}

	}

	public void DefineCondicionalMesaPerde() {

		MesaPerde = true;

	}

	public void DefineCondicionalMesaEmpata() {

		MesaEmpata = true;

	}

	public void DefineCondicionalMesaGanha() {

		MesaGanha = true;

	}

	public void resetaCondicionaisDeJogoMesa() {

		condicionalMesaGanha = false;
		condicionalMesaEmpata = false;
		condicionalMesaPerde = false;

		MesaEmpata = false;
		MesaGanha = false;
		MesaPerde = false;

	}

	public void ExibirPontuacaoMesa() {

		System.out.printf(" a pontuação da mesa até agora é de %d\n", PontuacaoMesa);

	}

	public int RetornaPontuacaoMesa() {

		return PontuacaoMesa;

	}

}
