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
        insertionSortV2(a, 0, a.length-1);
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
    
    /**
     * Excecutes an insertion sort as specified in the class description
     * except it sorts only elements in between index {@code l} and {@code r}
     * @param a Unsorted array of integers
     * @param l Index of the left-most element
     * @param r Index of the right-most element
     * @return The sorted array
     */
    public static int[] insertionSortV2(int[] a, int l, int r) {
        for (int i=l; i<r+1; i++) {
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
