package sorting;

/*
 * Implements two variants of insertion sort on an array of integers.
 * The algorithm is vaguely explained below, though it is very simple.
 */
public class InsertionSort extends Algorithm {

    private int[] a;
    
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
            + a.length
            + "\nElapsed Time: "
            + getElapsedTime()
            + "ns\n----------------------------------------\n";
    }
    
    /*
     * Executes an insertion sort on an array of integers.
     * Each element is inserted at its ordered position compared to the 
     * current array.
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
