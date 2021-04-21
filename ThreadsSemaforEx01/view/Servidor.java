package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class Servidor {

	public static void main(String[] args) {
		
		int permissão = 1;
		Semaphore semaforo = new Semaphore(permissão);
		
		for (int idThread = 0 ; idThread <21 ; idThread++) {
			Thread tCalc = new ThreadServidor(idThread, semaforo);
			tCalc.start();
		}

	}

}
