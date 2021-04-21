package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread{
	
	private int idPrato;
	private Semaphore semaforo;
	private String nomePrato;
	
	public ThreadCozinha(int idPrato , Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		cozinhando();
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}

	private void cozinhando() {
		if((idPrato%2) == 0) {
			nomePrato = "Lasanha a Bolonhesa";
			int tempoPreparo = (int)((Math.random() * 601) + 600);
			double progresso = 0;
			
			System.out.println("Panela #" + idPrato + ": " + nomePrato + " iniciou o cozimento.");
			
			while (progresso <100) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				progresso += (10000/tempoPreparo);
				if(progresso > 100) {
					progresso = 100;
				}
				System.out.println("Panela #" + idPrato + ": " + progresso + "%");
			}
			System.out.println("O Prato " + idPrato + ": " + nomePrato + " está pronto");
			
		}else {
			nomePrato = "Sopa de Cebola";
			int tempoPreparo = (int)((Math.random() * 301) + 500);
			double progresso = 0;
			
			System.out.println("Panela #" + idPrato + ": " + nomePrato + " iniciou o cozimento.");
			
			while (progresso <100) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				progresso += (10000/tempoPreparo);
				if(progresso > 100) {
					progresso = 100;
				}
				System.out.println("Panela #" + idPrato + ": " + progresso + "%");
			}
			System.out.println("O Prato " + idPrato + ": " + nomePrato + " está pronto");
		}
		
	}

	private void entrega() {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O Pedido " + idPrato + ": " + nomePrato + " foi entregue");
		
	}

}
