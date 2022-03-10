package view;

import controller.ThreadMatriz;

public class Principal {

	public static void main(String[] args) {
		int matriz[][] = new int[3][5];
		int vetor[] = new int[5];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = (int) (Math.random() * 11);
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("[" + matriz[i][j] + "]");
			}
			System.out.println("\n");
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				vetor[j] = matriz[i][j];
			}
			System.out.println("\n");
			Thread calc = new ThreadMatriz(i, vetor);
			calc.start();
			synchronized (calc) {
				try {
					calc.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
