package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class JogarController implements ActionListener{
	
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JButton btnJogar;
	
	public JogarController (JTextField textField1 , JTextField textField2 , JTextField textField3 , JButton btnJogar) {
		this.textField1 = textField1;
		this.textField2 = textField2;
		this.textField3 = textField3;
		this.btnJogar = btnJogar;
	}
	
	private void jogar () {
		Thread t1 = new JogarThread(textField1, btnJogar);
		Thread t2 = new JogarThread(textField2, btnJogar);
		Thread t3 = new JogarThread(textField3, btnJogar);
		t1.start();
		t2.start();
		t3.start();		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jogar();
	}
	
}
