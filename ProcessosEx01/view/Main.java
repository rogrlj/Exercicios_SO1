/*Objetivo: Main que chama m?todos na classe RedesController para reconhecer o SO,  
            chamada de configura??o do IP e calcula o PING m?dio
  Programador: Rog?rio Louren?o Junior
  Data: 07/09/2020
 */
package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redesController = new RedesController ();
		
//		Chamada da fun??o para reconhecimento do SO.
		String os = redesController.os();
		System.out.println("SISTEMA OPERACIONAL: " + os);
				
		int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu \n" + "\n1-Nome Adaptador Ethernet e IPv4 \n2-Tempo m?dio PING \n9-Finaliza \n" + "\n SO: " +os));
            switch (opc) {
                case 1: redesController.ip(os);
                        break;
                case 2: redesController.ping(os);
                        break;
                case 9: JOptionPane.showMessageDialog(null,"Programa finalizado");
                        break;
                default: JOptionPane.showMessageDialog(null,"Op??o Inv?lida");
            }
        }
	}

}
