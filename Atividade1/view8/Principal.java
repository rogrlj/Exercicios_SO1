package view8;
import java.util.Random;
import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OperacoesController op = new OperacoesController();
		
		Random random = new Random();
		int i;
		int vetor1[] = new int[100];
		int vetor2[] = new int[1000];
		int vetor3[] = new int[10000];
		
		for (i=0 ; i<100 ; i++) {
			vetor1[i] = random.nextInt(11);
		}
		op.somaVetor(vetor1);
		
		for (i=0 ; i<1000 ; i++) {
			vetor2[i] = random.nextInt(11);
		}
		op.somaVetor(vetor2);
		
		for (i=0 ; i<10000 ; i++) {
			vetor3[i] = random.nextInt(11);
		}
		op.somaVetor(vetor3);
	}

}
