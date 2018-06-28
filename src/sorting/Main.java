package sorting;

public class Main {

	public static void main(String[] args) {
		int n = 100;
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = (int)(Math.random()*n +1);
		}
		
		System.out.println("Bead sort:");
		long startTime = System.nanoTime();
		Algorithm.beadSort(a);
		long endTime = System.nanoTime();
		
		System.out.println("Array length: " + n);
		System.out.println("Execution time: " + (endTime-startTime) + "ns");
//		for (int i=0; i<n; i++)
//			System.out.println(a[i]);
		System.out.println("-------------------------------");
	}

}
