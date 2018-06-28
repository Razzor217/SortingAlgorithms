package sorting;

/*
 * Basic abstract class for an algorithm which supports execution, 
 * calculation of ellapsed time and string representation of 
 * former data to analyse execution time of different algorithms.
 */
public abstract class Algorithm {
	
	private String name;
	
	public Algorithm() {
	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void execute();
	
	public long ellapsedTime() {
		long startTime = System.nanoTime();
		execute();
		long endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	public abstract String toString();
	
	public static int[] quicksort(int[] a) {
		
		return a;
	}
	
	public static int[] insertionSort(int[] a) {
		
		return a;
	}

	public static int[] mergeSort(int[] a) {
		
		return a;
	}
	
	public static int[] quickSort_HalfRec(int[] a) {
		
		return a;
	}
	
	public static int[] sleepSort(int[] a) {
		
		return a;
	}
}
