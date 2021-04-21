package controller;

public class SomaVetor extends Thread {
	
	private int vet[] = new int [5];
	private int linha;
	
	public SomaVetor (int linha , int[] vet) {
		this.linha = linha;
		this.vet = vet;
	}
	
	@Override
	public void run() {
		int soma = 0;
		for (int i: vet) {
			soma = soma+i;
		}
		System.out.println("Soma da linha " + linha + " da matriz: " + soma);
	}

}
