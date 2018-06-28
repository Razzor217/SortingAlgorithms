package sorting;

/*
 * Basic abstract class for an algorithm which supports execution, 
 * calculation of elapsed time and string representation of 
 * former data to analyze execution time of different algorithms.
 */
public abstract class Algorithm implements Comparable<Algorithm>{
	
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
	
	public long elapsedTime() {
		long startTime = System.nanoTime();
		execute();
		long endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	// Algorithms are compared by execution time (here)
	@Override
	public int compareTo(Algorithm other) {
	    return Long.compare(elapsedTime(), other.elapsedTime());
	}
	
	// Basic insertion sort for sorting algorithms based on execution time
	public static Algorithm[] sort(Algorithm[] a) {
	    for (int i=0; i<a.length; i++) {
            Algorithm e = a[i];
            int j=i;
            while (j>i && a[j-1].compareTo(e)>0) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = e;
        }
	    return a;
	}
	
	public abstract String toString();
	
}