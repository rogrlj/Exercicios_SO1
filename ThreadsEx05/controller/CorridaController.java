package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CorridaController implements ActionListener{
	
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JButton btnCorrer;
	private JTextArea textAreaV;
	private JTextArea textAreaP;
	
	public CorridaController(JLabel lblCarro1, JLabel lblCarro2, JButton btnCorrer, 
								JTextArea textAreaV, JTextArea textAreaP ) {
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.btnCorrer = btnCorrer;
		this.textAreaP = textAreaP;
		this.textAreaV = textAreaV;
	}
	
	private void botaoCorrer () {
		
		Thread t1 = new ThreadCorrida(lblCarro1, btnCorrer, textAreaV, textAreaP);
		Thread t2 = new ThreadCorrida(lblCarro2, btnCorrer, textAreaV, textAreaP);
		t1.start();
		t2.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		botaoCorrer();
	}

}
