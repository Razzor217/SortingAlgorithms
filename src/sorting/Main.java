package sorting;

public class Main {

	public static void main(String[] args) {
		int n = 10000;
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = (int)(Math.random()*n +1);
		}
		
		Algorithm[] b = {new BeadSort(a)};
		printAlgorithms(b);
	}
	
	public static void printAlgorithms(Algorithm[] a) {
	    for (int i=0; i<a.length; i++)
	        System.out.print(a[i].toString());
	}

}
