package controller;

import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread{
	
	private int idThread;
	private Semaphore semaforo;
	private int resto;
	public ThreadServidor(int idThread , Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		resto = idThread % 3;
		int transa�oes;
		if (resto == 1) {
			transa�oes = 2;
		}else {
			transa�oes = 3;
		}
		
		for(int i=0 ; i<transa�oes ; i++) {
			calculo();
			try {
				semaforo.acquire();
				transa��o();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		}
		
		
	}

	

	private void calculo() {
		int tempo;
		
		System.out.println("Thread #" + idThread + " est� calculando");
		
		switch (resto) {
		case 0:
			tempo = (int)((Math.random() * 1001) + 1000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			tempo = (int)((Math.random() * 801) + 200);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			tempo = (int)((Math.random() * 1001) + 500);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}
	
	private void transa��o() {
		
		System.out.println("Gravando Thread #" + idThread + " no banco de dados");
		if (resto == 1) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
