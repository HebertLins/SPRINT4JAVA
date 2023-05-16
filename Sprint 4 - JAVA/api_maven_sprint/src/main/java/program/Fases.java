package program;

import java.util.Scanner;

public class Fases {
	int idFase;
	String tipos;
	Corretoras fase;
	int opDif;
	int saldoM;
	int i;
	int qntFases;
	
	Scanner ler = new Scanner(System.in);
	
	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public String getTipos() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public Corretoras getFase() {
		return fase;
	}

	public void setFase(Corretoras fase) {
		this.fase = fase;
	}

	public int getOpDif() {
		return opDif;
	}

	public void setOpDif(int opDif) {
		this.opDif = opDif;
	}

	public int getSaldoM() {
		return saldoM;
	}

	public void setSaldoM(int saldoM) {
		this.saldoM = saldoM;
	}

	Fases() {}
	
	Fases(int idFase, String tipos, Corretoras fase){
		this.fase = fase;
		this.idFase = idFase;
		this.tipos = tipos;
	}
	
	public String Fases () {
		System.out.println("Selecione uma dificuldade:\n"
				+ "- Dificuldade 1 \n"
				+ "- Dificuldade 2 \n"
				+ "- Dificuldade 3 \n"
				+ "- Dificuldade 4 \n");
		opDif = ler.nextInt();
		if (opDif == 1) {
			this.setSaldoM(this.getSaldoM() + 30);
			System.out.printf("Você acaba de receber 30 moedas!"
					+ "\n Seu saldo total de moedas é %d", this.getSaldoM());
		}else if (opDif == 2) {
			this.setSaldoM(this.getSaldoM() + 50);
			System.out.printf("Você acaba de receber 50 moedas!"
					+ "\n Seu saldo total de moedas é %d", this.getSaldoM());
		}else if (opDif == 3) {
			this.setSaldoM(this.getSaldoM() + 80);
			System.out.printf("Você acaba de receber 80 moedas!"
					+ "\n Seu saldo total de moedas é %d", this.getSaldoM());
		}else if (opDif == 4) {
			this.setSaldoM(this.getSaldoM() + 150);
			System.out.printf("Você acaba de receber 150 moedas!"
					+ "\n Seu saldo total de moedas é %d", this.getSaldoM());
		}
		return ("Teste de fase concluído!");
	}
	
	public String Simulado() {
		System.out.println(("Simulado se baseia em um grande questionário referente à IPO, onde você poderá testar seus conhecimentos\n"
				+ "No momento ele não está disponível! Estamos trabalhando nisso.\n"
				+ "Simulado finalizado!"));
		return ("");
	}
	
	public String BarraProg () {
		System.out.println("Bem-vindo ao calculador de barra de progresso!");
		System.out.println("Quantas fases você finalizou até o momento?");
		qntFases = ler.nextInt();
		System.out.print("_\n");
		for (i=1;i<=qntFases;i++) {
			System.out.println("=");
		}for (i=1;i<=15-qntFases;i++) {
			System.out.print(" \n");
		}
		System.out.print("_");
		double porcentagem = (qntFases * 100)/15;
		System.out.println(("\nBarra de progresso de " + porcentagem + "% "));
		return ("");
	 }
}

