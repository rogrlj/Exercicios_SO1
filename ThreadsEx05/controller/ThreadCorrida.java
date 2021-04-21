package controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ThreadCorrida extends Thread {
	
	private JLabel lblCarro;
	private JButton btnCorrer;
	private JTextArea textAreaV;
	private JTextArea textAreaP;
	static int colocação;
	int distancia;
	
	public ThreadCorrida (JLabel lblCarro, JButton btnCorrer, JTextArea textAreaV,
							JTextArea textAreaP) {
		this.lblCarro = lblCarro;
		this.btnCorrer = btnCorrer;
		this.textAreaV = textAreaV;
		this.textAreaP = textAreaP;
		
	}
	
	private void mexeCarro() {
		btnCorrer.setEnabled(false);
		Rectangle posição;
		Random random = new Random();
		
		int mov = 0;
		
		posição = lblCarro.getBounds();
		lblCarro.setBounds(posição);
		distancia = posição.x + posição.width;
		
		while (distancia<=500) {
			mov = random.nextInt(10);
			if(distancia + mov > 500) {
				posição.x = 500 - posição.width;
			} else {
				posição.x = posição.x + mov;
			}
			lblCarro.setBounds(posição);
			distancia = distancia + mov;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		colocação++;
		if (colocação == 1) {
			textAreaV.setText(lblCarro.getText());
		} else {
			textAreaP.setText(lblCarro.getText());
		}
		
	}
	
	@Override
	public void run() {
		mexeCarro();
	}

}
