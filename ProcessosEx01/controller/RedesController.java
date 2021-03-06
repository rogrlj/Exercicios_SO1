/*Objetivo: M?todos que ao serem chamados pelo Main realize as seguintes tarefas: Reconhecer o SO,  
            chamada de configura??o do IP e calcula o PING m?dio em 10 itera??es.
  Programador: Rog?rio Louren?o Junior
  Data: 07/09/2020
 */

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	
	public RedesController () {
		super();
	}
	
//	Fun??o que reconhecer? o Sistema Operacional
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
//	Procedimento para chamar processos no Windows
	public String callProcessW (String process) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("cmd /c");
		buffer.append(" ");
		buffer.append(process);
		return (buffer.toString());
	}
	
	
//	Procedimento que faz a chamada de configura??o do IP
	public void ip(String os) {
		String bf = "ADAPTADORES ETHERNET E IPv4: \n";
		System.out.println("\n====================================");
		System.out.println("ADAPTADORES ETHERNET E IPv4: " + "\n");
		if (os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(callProcessW("ipconfig"));
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Adaptador")){
						System.out.println(linha);
						bf += linha + "\n";
						linha = buffer.readLine();
					}
					else if(linha.contains("IPv4")) {
						System.out.println(linha);
						bf += linha + "\n";
						linha = buffer.readLine();
					}
					else {
						linha = buffer.readLine();
					}
						
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Ethernet")){
						System.out.println(linha);
						bf += linha +"\n";
						linha = buffer.readLine();
					}
					else if(linha.contains("inet")) {
						System.out.println(linha);
						bf += linha + "\n";
						linha = buffer.readLine();
					}
					else {
						linha = buffer.readLine();
					}
						
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, bf);
	}
	
//	Procedimento que calcula o PING m?dio em 10 itera??es
	public void ping (String os) {
		String bf = "PING M?dio: \n";
		System.out.println("\n====================================");
		System.out.println("\nPING m?dio: ");
		if (os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(callProcessW("ping -n 10 www.google.com.br"));
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("ximo")){
						System.out.println(linha.substring(41));
						bf += linha.substring(41);
						linha = buffer.readLine();
					}
					else {
						linha = buffer.readLine();
					}
						
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("avg")){
						System.out.println(linha.substring(30, 36) + "ms");
						bf += linha.substring(30, 36) + "ms";
						linha = buffer.readLine();
					}
					else {
						linha = buffer.readLine();
					}
						
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, bf);
	}
}