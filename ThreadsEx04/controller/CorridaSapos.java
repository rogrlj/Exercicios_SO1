package controller;

import java.util.Random;

public class CorridaSapos extends Thread {
	
	private int sapo;
	private int maxDist;
	private int maxPulo;
	static int posição; 
	
	
	public CorridaSapos (int sapo, int maxDist, int maxPulo) {
		this.sapo = sapo;
		this.maxDist = maxDist;
		this.maxPulo = maxPulo;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		int dist = 0;
		int pulo = 0;
		String result = " ";
		while ( dist < maxDist) {
			pulo = random.nextInt(maxPulo);
			dist = dist + pulo;
			System.out.println("O sapo " + sapo + " pulou " + pulo + " metros, e agora já percorreu " + dist + " metros");
		}
		posição ++;
		result += ("\nO sapo " + sapo + " chegou em " + posição + "º lugar");
		try {
			sleep (sapo * 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}
	

}
