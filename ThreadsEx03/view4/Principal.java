package view4;

import java.util.Random;

import controller.SomaVetor;

public class Principal {

	public static void main(String[] args) {
		
		int mat [][] = new int [3][5];
		Random random = new Random();
		
		for (int i=0 ; i<3; i++) {
			for (int j=0 ; j<5; j++) {
				mat[i][j] = random.nextInt(100);
			}
		}
		for (int i=0 ; i<3; i++) {
			Thread soma = new SomaVetor (i+1, mat[i]);
			soma.start();
		}
	}

}
