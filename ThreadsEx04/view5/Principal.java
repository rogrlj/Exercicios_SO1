package view5;

import java.util.Random;

import controller.CorridaSapos;


public class Principal {
	public static void main(String[] args) {
		
		Random random = new Random();
		//GERANDO DE FORMA ALEATÓRIA A DISTANCIA DA CORRIDA ENTRE 30 A 50 METROS
		int Dist = random.nextInt((20) + 1) + 30;  	
		//GERANDO DE FORMA ALEATÓRIA A DISTANCIA DO MÁXIMA DO PULO ENTRE 5 E 10 METROS
		int pulo = random.nextInt((5)+1) + 5;  		
		
		System.out.println("CADA SAPO TERÁ DE PERCORRER " + Dist + " METROS"
							+ "\nCADA SAPO CONSEGUE DAR UM PULO DE ATÉ " + pulo + " METROS \n");
		
		
		for (int sapo = 0; sapo<5; sapo++) {
			Thread corrida = new CorridaSapos (sapo + 1, Dist, pulo);
			corrida.start();
		}
	}
}
