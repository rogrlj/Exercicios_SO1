package view6;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.JogarController;

import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField1.setEditable(false);
		textField1.setBounds(32, 108, 77, 53);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setBounds(129, 108, 77, 53);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField3.setEditable(false);
		textField3.setColumns(10);
		textField3.setBounds(227, 108, 77, 53);
		contentPane.add(textField3);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(309, 208, 89, 23);
		contentPane.add(btnJogar);
		
		
		JogarController jogar = new JogarController(textField1, textField2, textField3, btnJogar);
		btnJogar.addActionListener(jogar);
	}
}
