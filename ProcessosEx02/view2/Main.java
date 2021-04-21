/*Objetivo: Main que chama métodos na classe ProcessosController para reconhecer o SO,  
            mostrar os processos e matar processos
  Programador: Rogério Lourenço Junior
  Data: 08/09/2020
 */
package view2;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Main{
	
	public static void main(String[] args) {
		ProcessosController processController = new ProcessosController();
		String os = processController.os();
		System.out.println("SISTEMA OPERACIONAL: " + os);
		
		
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu \n" +  "\n 1 - Mostrar Processos" + "\n 2 - Matar Processo" + "\n 9 - Finalizar \n" + "\n SO: " +os));
			switch (opc) {
			case 1:
				processController.readProcess(os);
				break;
			case 2:
				String param = JOptionPane.showInputDialog("Digite o Nome ou PID do processo que deseja matar:");
				processController.killProcess(os, param);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida.");
			}
		}
	}
}