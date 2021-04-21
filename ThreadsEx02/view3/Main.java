package view3;

import controller.ThreadsId;


public class Main {

	public static void main(String[] args) {
		for (int idThread = 0 ; idThread <10 ; idThread++) {
			Thread threadId = new ThreadsId(idThread);
			threadId.start();
		}
	}

}
