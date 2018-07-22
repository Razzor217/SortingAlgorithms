package sorting;

/**
 * Implements quick sort on arrays of integers, generic variant needs to be 
 * added. 
 * Quicksort divides any sequence of comparable objects into three parts:
 * <ol> 
 *      <li>sequence containing objects smaller than pivot</li>
 *      <li>pivot element</li>
 *      <li>sequence containing objects greater than or equal to pivot</li>
 * </ol>
 * The same algorithm is then applied to sequences 1 and 3 which builds the 
 * recursion of quick sort.<p>
 * Time complexity: {@code O(n*log n)}
 * 
 * @author Max Beddies
 */
public class QuickSort extends Algorithm {

    protected int[] a;
    
    /**
     * Initializes quick sort with an integer array.
     * @param a The unsorted array
     */
    public QuickSort(int[] a) {
        super();
        setName("Quicksort");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
        for (int i=0; i<a.length; i++)
            this.a[i] = a[i];
    }
    
    @Override
    public void execute() {
        quickSort(a, 0, a.length-1);   
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
     * Executes quick sort as specified in the class description.
     * @param a Unsorted integer array
     * @param l Index of the left-most array element (start of array)
     * @param r Index of the right-most array element (end of array)
     * @return The sorted array
     */
    public static int[] quickSort(int[] a, int l, int r) {
        if (l<r) {
            int k = pickPivot(a, l, r);
            int t = partition(a, l, r, k);
            quickSort(a, l, t-1);
            quickSort(a, t+1, r);
        }
        return a;
    }
    
    /**
     * Partitions the array into three parts by swapping all elements 
     * which are smaller than the pivot element to the left of the pivot 
     * element.
     * @param a The unsorted array
     * @param l Index of the left-most element 
     * @param r Index of the right-most element
     * @param k Index of the pivot element
     * @return Index of the pivot element, determines bounds of next recursion
     */
    public static int partition(int[] a, int l, int r, int k) {
        int p = a[k];
        swap(a, k, r);
        int i = l;
        for (int j=l; j < r; j++) {
            if (a[j]<=p) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }
    
    /**
     * Swaps two elements of an array
     * @param a Array containing both integers
     * @param l Index of the 1st integer
     * @param r Index of the 2nd integer
     */
    public static final void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
    
    /**
     * Chooses the index of the pivot element
     * @param a Unsorted array
     * @param l Left bound of the array
     * @param r Right bound of the array
     * @return The index of the pivot element
     */
    public static int pickPivot(int[] a, int l, int r) {
        return r;
    }
}
