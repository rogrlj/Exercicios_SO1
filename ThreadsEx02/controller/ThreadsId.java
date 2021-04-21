package controller;

public class ThreadsId extends Thread {
	
	private int idThread;
	
	public ThreadsId (int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		System.out.println("#THREAD DE NUMERO ==> " + idThread);
	}
}
