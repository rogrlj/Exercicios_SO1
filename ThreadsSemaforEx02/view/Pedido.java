package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCozinha;

public class Pedido {

	public static void main(String[] args) {
		
		int permiss�o = 1;
		Semaphore semaforo = new Semaphore(permiss�o);
		
		for (int idPrato = 0 ; idPrato < 5 ; idPrato++) {
			Thread tCozinha = new ThreadCozinha(idPrato, semaforo);
			tCozinha.start();
		}

	}

}
