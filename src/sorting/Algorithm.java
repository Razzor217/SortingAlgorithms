package sorting;

/**
 * Basic abstract class for an algorithm which supports execution, 
 * calculation of elapsed time and string representation of 
 * former data to analyze execution time of different algorithms.
 * <p>
 * Different variants of the same algorithm are implemented in different 
 * subclasses of {@code Algorithm} if they differ vastly or if they are implemented on 
 * top of different data structures (e.g. array vs linked list).
 * 
 * @author Max Beddies
 */
public abstract class Algorithm implements Comparable<Algorithm>{
	
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
	private String name;
	private long elapsedTime;
	
	/**
	 * Initializes an algorithm with {@code null} name and 
	 * {@code elapsedTime=0}, must be overwitten by subclasses 
	 */
	public Algorithm() {
	    name = null;
	    elapsedTime = 0;
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
	
	/**
	 * Executes the algorithm once.
	 */
	public abstract void execute();
	
	/**
	 * Measures the execution time of the algorithm by executing it once.
	 * @return The exevution time of the algorithm
	 */
	public long elapsedTime() {
		long startTime = System.nanoTime();
		execute();
		long endTime = System.nanoTime();
		setElapsedTime(endTime-startTime);
		return getElapsedTime();
	}
	
	
	/**
	 * Algorithms can be compared by execution time.
	 */
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
	
	/**
	 * Returns a string representation of the algorithms name,  
	 * execution time and other useful information. 
	 */
	public abstract String toString();
	
}