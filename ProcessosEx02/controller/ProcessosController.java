/*Objetivo: Métodos que ao serem chamados pelo Main realize as seguintes tarefas: Reconhecer o SO,  
             mostra todos os processos e matar processos pelo PID ou o nome.
  Programador: Rogério Lourenço Junior
  Data: 08/09/2020
 */

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ProcessosController{
	
	public ProcessosController() {
		super();
	}
	
//	Função que reconhecerá o Sistema Operacional
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
//	Procedimento que mostra todos os processos
	public void readProcess(String SO) {
		if (SO.contains("Windows")){
			String process = "tasklist";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			String process = "ps -ef";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
//	Procedimento para matar processos pelo PID ou o nome
	public void killProcess(String SO, String param) {
				if (SO.contains("Windows")){
					String cmdPid = "taskkill /pid ";
					String cmdName = "taskkill /IM ";
					StringBuffer buffer = new StringBuffer();
					int pid = 0;
					try {
						pid = Integer.parseInt(param);
						buffer.append(cmdPid);
						buffer.append(pid);
					} catch (NumberFormatException e) {
						int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente matar todos: " + param + "?");
						if (confirm == 0) {
							buffer.append(cmdName);
							buffer.append(param);
							if (!param.contains(".exe")) {
								buffer.append(".exe");
							}
						}
					}
					
						try {
							Runtime.getRuntime().exec(buffer.toString());
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
				else{
					String cmdPid = "kill ";
					StringBuffer buffer = new StringBuffer();
					int pid = 0;
					try {
						pid = Integer.parseInt(param);
						buffer.append(cmdPid);
						buffer.append(pid);
						try {
							Runtime.getRuntime().exec(buffer.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
					} catch (NumberFormatException e) {
						int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente matar todos: " + param + "?");
						if (confirm == 0) {
							try {
								String[] ln;
								Process p = Runtime.getRuntime().exec("ps -ef");
								InputStream fluxo = p.getInputStream();
								InputStreamReader leitor = new InputStreamReader(fluxo);
								BufferedReader buffer1 = new BufferedReader(leitor);
								String linha = buffer1.readLine();
								while (linha != null) {
									if (linha.contains(param)){
										ln = linha.split("\\s+");
										pid = Integer.parseInt(ln[1]);
										buffer.append(cmdPid);
										buffer.append(pid);
										Runtime.getRuntime().exec(buffer.toString());
										buffer.delete(0, buffer.length());
									}
									linha = buffer1.readLine();
								}
								buffer1.close();
								leitor.close();
								fluxo.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
	}
}