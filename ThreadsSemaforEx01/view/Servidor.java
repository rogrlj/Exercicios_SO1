package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class Servidor {

	public static void main(String[] args) {
		
		int permiss�o = 1;
		Semaphore semaforo = new Semaphore(permiss�o);
		
		for (int idThread = 0 ; idThread <21 ; idThread++) {
			Thread tCalc = new ThreadServidor(idThread, semaforo);
			tCalc.start();
		}

	}

}
