package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	
	private int idPessoa;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadPessoa(int idPessoa , Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		pessoaAndando();
//		===============Início Seção Crítica=============
		try {
			semaforo.acquire();
			cruzandoPorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			pessoaSaindo();
		}
		
//		===============Fim Seção Crítica================

			}
	
	

	private void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = 0;
		int tempo = 1000; 
		
		while (distanciaPercorrida < distanciaTotal) {
			deslocamento =(int)((Math.random() * 3) + 4);
			distanciaPercorrida += deslocamento;
			
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("A Pessoa " + idPessoa + " já andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("A Pessoa " + idPessoa + " foi a " + posChegada + "ª pessoa a chegar na porta");
	}

	private void cruzandoPorta() {
		System.out.println("A Pessoa " + idPessoa + " abriu a porta");
		int tempo = (int)((Math.random() * 1001) +1000);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A Pessoa " + idPessoa + " cruzou a porta");
		
	}

	private void pessoaSaindo() {
		posSaida++;
		System.out.println("A Pessoa " + idPessoa + " foi a " + posSaida + "ª a cruzar a porta");
	}
	

}
