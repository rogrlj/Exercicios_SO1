package controller;

public class OperacoesController {
	
	public OperacoesController() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void somaVetor(int vetor[]) {
		int result = 0;
		double tempoInicial = System.nanoTime();
		for (int valor: vetor) {
			result = result + valor;
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal =  tempoFinal - tempoInicial;
//		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("Tempo iteração vetor ==> " + tempoTotal + "ns.");
		System.out.println("Resultado da soma: " + result);
	}
}
