package controller;

public class ThreadMatriz extends Thread {

	private int[] vetor;
	private int j;

	public ThreadMatriz(int j, int[] vetor) {
		this.j = j;
		this.vetor = vetor;
	}

	@Override
	public void run() {
		SomaVetores();
	}

	private void SomaVetores() {
		int soma = 0;
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			for (int y = 0; y < 5; y++) {
				soma += vetor[y];
			}
			System.out.println((j + 1) + " Resultado da Soma: " + soma);
		}
	}
}
