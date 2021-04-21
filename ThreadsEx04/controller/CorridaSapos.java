package controller;

import java.util.Random;

public class CorridaSapos extends Thread {
	
	private int sapo;
	private int maxDist;
	private int maxPulo;
	static int posi��o; 
	
	
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
			System.out.println("O sapo " + sapo + " pulou " + pulo + " metros, e agora j� percorreu " + dist + " metros");
		}
		posi��o ++;
		result += ("\nO sapo " + sapo + " chegou em " + posi��o + "� lugar");
		try {
			sleep (sapo * 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}
	

}
