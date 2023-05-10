package esercizio2;

import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) {
		int[] array = generateRandomArray(3000);

		int[] partialSums = new int[3];
		Thread[] threads = new Thread[3];

		// Creazione thread
		for (int i = 0; i < 3; i++) {
			int startIndex = i * 1000;
			int endIndex = startIndex + 1000;
			threads[i] = new SumThread(array, startIndex, endIndex, partialSums, i);
			threads[i].start();
		}

		// attendo che finiscono uno alla volta
		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// calcolo il totale
		int totalSum = 0;
		for (int sum : partialSums) {
			totalSum += sum;
		}

		System.out.println("Somma parziale: " + Arrays.toString(partialSums));
		System.out.println("Somma totale: " + totalSum);
	}

	// metodo array numeri casuali
	private static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	// Thread class per calcolare somma e dividere array
	private static class SumThread extends Thread {
		private int[] array;
		private int startIndex;
		private int endIndex;
		private int[] partialSums;
		private int threadIndex;

		public SumThread(int[] array, int startIndex, int endIndex, int[] partialSums, int threadIndex) {
			this.array = array;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.partialSums = partialSums;
			this.threadIndex = threadIndex;
		}

		@Override
		public void run() {
			int sum = 0;
			for (int i = startIndex; i < endIndex; i++) {
				sum += array[i];
			}
			partialSums[threadIndex] = sum;
		}
	}
}