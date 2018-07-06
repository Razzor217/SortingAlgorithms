package sorting;

/**
 * Abstract class implementing a bucket sort on top of an integer array.<p>
 * For a given amount of buckets {@code K}, elements get assigned a key in the 
 * range of {@code 0...K-1}. In an auxiliary array, the number of elements for 
 * each bucket is counted and then transformed into indices for the resulting
 * array, i.e. the auxiliary array holds the starting indices for each bucket.
 * The resulting array is then refilled using the indices in the auxiliary 
 * arrax.<p>
 * Each subclass has to implement a method which calculates a key for any 
 * integer within a given range.<p>
 * Time complexity: {@code O(n+K)}
 * 
 * @author Max Beddies
 *
 */
public abstract class KSortArray extends Algorithm {

    protected int[] a;
    protected int K;
    
    /**
     * Initializes kSort with an array of integers.
     * @param a The unsorted array
     * @param K The amount of buckets
     */
    public KSortArray(int[] a, int K) {
        super();
        setName("Bucket Sort");
        this.K = K;
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
        for (int i=0; i<a.length; i++)
            this.a[i] = a[i];
    }
    
    @Override
    public void execute() {
        kSort(a);
        
    }

    @Override
    public String toString() {
        return getName()
            + ":\nArray Length: "
            + String.format("%,26d", a.length)
            + "\nElapsed Time: " 
            + String.format("%,23d", getElapsedTime())
            + " ns\n----------------------------------------\n";
    }
    
    /**
     * Executes a kSort as specified in the class description.
     * @param a The unsorted array
     * @return The sorted array
     */
    public int[] kSort(int[] a) {
        int n = a.length;
        int[] c = new int[K];
        int[] b = new int[n];
        
        // Count number of elements in each bucket
        for (int i=0; i<n; i++)
            c[key(a[i])]++;
        // Transform auxiliary array to contain indices of buckets
        int C = 0;
        for (int k=0; k<K; k++) {
            int temp = C;
            C = C+c[k];
            c[k] = temp;
        }
        // Fill buckets
        for (int i=0; i<n; i++)
            b[c[key(a[i])]++] = a[i];
        return b;
    }
    
    /**
     * Calculates a key in the range {@code 0...K-1} for a given integer 
     * {@code a}. Restrictions on the range of integers may occur on special 
     * algorithms.
     * @param a The integer to assign a key to
     * @return The key for the given integer
     */
    public abstract int calculateKey(int a);
    
    /**
     * Checks whether the calculated key for a given integer is in range of 
     * {@code 0...K} to fit in the buckets.
     * @param a The integer to check the key from
     * @return The key if it is within range
     * @throws IllegalArgumentException If calculated key is not within range
     */
    private int key(int a) {
        int key = calculateKey(a);
        if (key < 0 || key > K)
            throw new IllegalArgumentException("Error, key not within range");
        return key;
    }

}
