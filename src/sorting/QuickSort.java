package sorting;

/*
 * Implements quick sort on arrays of integers, generic variant needs to be 
 * added. 
 * Quicksort divides any sequence of comparable objects into three parts: 
 *      1. sequence containing objects smaller than pivot
 *      2. pivot element
 *      3. sequence containing objects greater than or equal to pivot
 * The same algorithm is then applied to sequences 1 and 3 which builds the 
 * recursion of quick sort.
 */
public class QuickSort<T extends Comparable<T>> extends Algorithm {

    private int[] a;
    
    public QuickSort(int[] a) {
        super();
        setName("Quicksort");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
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
    
    public T[] quickSort(T[] a) {
        
        return a;
    }

    /*
     * a - array to be sorted
     * l - left most index to apply partitioning on
     * r - right most index to apply partitioning on
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
    
    /*
     * Swaps two objects in an array
     */
    public static final void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
    
    /*
     * Picks the pivot element, could be implemented to pick randomly
     */
    public static int pickPivot(int[] a, int l, int r) {
        return r;
    }
}
