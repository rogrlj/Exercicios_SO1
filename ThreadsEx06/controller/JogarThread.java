package controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class JogarThread extends Thread{
	
	private JTextField textField;
	private JButton btnJogar;
	
	public JogarThread (JTextField textField , JButton btnJogar) {
		
		this.textField = textField;
		this.btnJogar = btnJogar;
	}
	
	
	private void jogar() {
		btnJogar.setEnabled(false);
		
		Random random = new Random();
		
		int contador = 1;
		int rodadas = random.nextInt(150)+1;
		String texto = " ";
		
		for (int i=0 ; i < rodadas ; i++ ) {
			
			switch (contador) {
			case 1:
				texto = "1";
				break;
			case 2:
				texto = "2";
				break;
			case 3:
				texto = "3";
				break;
			case 4:
				texto = "4";
				break;
			case 5:
				texto = "5";
				break;
			case 6:
				texto = "6";
				break;
			case 7:
				texto = "7";
				break;
			}
			
			textField.setText(texto);
			contador = random.nextInt(7)+1;
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		jogar();
		btnJogar.setEnabled(true);
	}

}
