package sorting;

/*
 * Basic abstract class for an algorithm which supports execution, 
 * calculation of elapsed time and string representation of 
 * former data to analyze execution time of different algorithms.
 */
public abstract class Algorithm implements Comparable<Algorithm>{
	
	private String name;
	private long elapsedTime;
	private int variants;
	
	public Algorithm() {
	    name = null;
	    elapsedTime = 0;
	    variants = 1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getElapsedTime() {
	    return elapsedTime;
	}
	
	public void setElapsedTime(long time) {
	    elapsedTime = time;
	}
	
	public int getVariants() {
	    return variants;
	}
	
	protected void setVariants(int variants) {
	    this.variants = variants;
	}
	
	/*
	 * Change the used variant of the algorithm
	 */
	public abstract void execute(int k);
	
	public long elapsedTime(int k) {
		long startTime = System.nanoTime();
		execute(k);
		long endTime = System.nanoTime();
		setElapsedTime(endTime-startTime);
		return getElapsedTime();
	}
	
	// Algorithms are compared by execution time (here)
	@Override
	public int compareTo(Algorithm other) {
	    return Long.compare(getElapsedTime(), other.getElapsedTime());
	}
	
	// Basic insertion sort for sorting algorithms based on execution time
	public static Algorithm[] sort(Algorithm[] a) {
	    for (int i=0; i<a.length; i++) {
            Algorithm e = a[i];
            int j=i;
            while (j>0 && a[j-1].compareTo(e)>0) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = e;
        }
	    return a;
	}
	
	public abstract String toString();
	
}