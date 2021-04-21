package view7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.CorridaController;


public class Main extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 654, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro1 = new JLabel("Carro1");
		lblCarro1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCarro1.setForeground(Color.BLUE);
		lblCarro1.setBounds(20, 52, 64, 54);
		contentPane.add(lblCarro1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 103, 531, 20);
		contentPane.add(separator);
		
		JLabel lblCarro2 = new JLabel("Carro2");
		lblCarro2.setForeground(Color.RED);
		lblCarro2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCarro2.setBounds(20, 103, 64, 54);
		contentPane.add(lblCarro2);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(10, 284, 89, 23);
		contentPane.add(btnCorrer);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVencedor.setBounds(225, 200, 74, 39);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerdedor.setBounds(225, 239, 74, 39);
		contentPane.add(lblPerdedor);
		
		JTextArea textAreaV = new JTextArea();
		textAreaV.setEditable(false);
		textAreaV.setBounds(309, 209, 89, 20);
		contentPane.add(textAreaV);
		
		JTextArea textAreaP = new JTextArea();
		textAreaP.setEditable(false);
		textAreaP.setBounds(309, 248, 89, 20);
		contentPane.add(textAreaP);
	
	
		CorridaController corrida = new CorridaController(lblCarro1, lblCarro2, btnCorrer, textAreaV, textAreaP);
		btnCorrer.addActionListener(corrida);
	}
	

}
