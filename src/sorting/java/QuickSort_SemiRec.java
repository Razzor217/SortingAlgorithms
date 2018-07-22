package sorting;

/**
 * Implements a semi recursive variant of quick sort which uses
 * insertion sort once the list is small enough.
 * Additionally, recursion only gets applied on the smaller part of the list.
 * 
 * @author Max Beddies
 *
 */
public class QuickSort_SemiRec extends QuickSort {

    private int n;
    
    /**
     * Initializes a semi recursive quick sort with an integer array and 
     * an integer determining when to use insertion sort instead of quick sort
     * @param a The unsorted array
     * @param n List length marking the switch to insertion sort
     */
    public QuickSort_SemiRec(int[] a, int n) {
        super(a);
        this.n = n;
        setName("QuickSort (semi recursive)");
    }
    
    @Override
    public void execute() {
        quickSort(a, 0, a.length-1, n);
    }
    
    /**
     * Executes a semi recursive quick sort as specified in the class 
     * description
     * @param a The unsorted integer array
     * @param l Index of the left-most element
     * @param r Index of the right-most element
     * @param n Length marking the switch to insertion sort
     * @return The sorted array
     */
    public static int[] quickSort(int[] a, int l, int r, int n) {
        if (l<r) {
            while (r-l+1 > n) {
                int k = pickPivot(a, l, r);
                int m = partition(a, l, r, k);
                int floor = (int) Math.floor((l+r)/2d);
                // Use quick sort recursively only on smaller part of the array
                if (m<floor) {
                    quickSort(a, l, m-1, n);
                    l = m+1;
                } else {
                    quickSort(a, m+1, r, n);
                    r = m-1;
                }
            }
            InsertionSort.insertionSortV2(a, l, r);
        }
        return a;
    }

}
