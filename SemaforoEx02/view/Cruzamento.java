package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Cruzamento {

	public static void main(String[] args) {
		
		int permiss�o = 1;
		Semaphore semaforo = new Semaphore(permiss�o);
		
		for (int idCarro = 0 ; idCarro < 4 ; idCarro++) {
			Thread tCarro = new ThreadCruzamento(idCarro + 1, semaforo);
			tCarro.start();
		}
	}
}
