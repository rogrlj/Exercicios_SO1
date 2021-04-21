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
	static int coloca��o;
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
		Rectangle posi��o;
		Random random = new Random();
		
		int mov = 0;
		
		posi��o = lblCarro.getBounds();
		lblCarro.setBounds(posi��o);
		distancia = posi��o.x + posi��o.width;
		
		while (distancia<=500) {
			mov = random.nextInt(10);
			if(distancia + mov > 500) {
				posi��o.x = 500 - posi��o.width;
			} else {
				posi��o.x = posi��o.x + mov;
			}
			lblCarro.setBounds(posi��o);
			distancia = distancia + mov;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		coloca��o++;
		if (coloca��o == 1) {
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
