package sorting;

/**
 * Implements insertion sort on top of an integer array. Each element is 
 * swapped into its ordered position compared to all other elements in the 
 * array.<p>
 * Time complexity: {@code O(n^2)}
 * 
 * @author Max Beddies
 *
 */
public class InsertionSort extends Algorithm {

    private int[] a;
    
    /**
     * Initializes insertion sort with an integer array
     * @param a The unsorted integer array
     * @throws NullPointerException If input array is not initialized
     */
    public InsertionSort(int[] a) {
        super();
        setName("Insertion Sort");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
        for (int i=0; i<a.length; i++)
            this.a[i] = a[i];
    }
    
    @Override
    public void execute() {
        insertionSortV2(a);
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
     * Executes an insertion sort as specified in the class description
     * @param a The unsorted array
     * @return The sorted array
     */
    public static int[] insertionSort(int[] a) {
        for (int i=1; i<a.length; i++) {
            int e = a[i];
            if (e < a[1]) {
                for (int j=i; j>0; j--)
                    a[j] = a[j-1];
                a[0] = e;
            } else {
                int j;
                for (j=i; a[j-1]>e; j--)
                    a[j] = a[j-1];
                a[j] = e;
            }
        }
        return a;
    }
    
    /*
     * Shorter implementation of insertion sort.
     * Less code and shorter runtime.
     */
    public static int[] insertionSortV2(int[] a) {
        for (int i=0; i<a.length; i++) {
            int e = a[i];
            int j=i;
            while (j>0 && a[j-1]>e) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = e;
        }
        return a;
    }

}
