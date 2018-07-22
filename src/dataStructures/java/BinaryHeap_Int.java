package dataStructures;

/**
 * Implements a binary heap on top of an integer array
 * (all key values and all element values are of integer type).
 * @see dataStructures.Heap
 * @see dataStructures.PriorityQueue
 * 
 * @author Max Beddies
 *
 */
public class BinaryHeap_Int implements Heap_Int {

    private int[] h;
    private int n;
    private int w;
    
    /**
     * Initializes a new heap from an integer array.
     * For easier checking of heap properties, the internal array is 
     * shifted by one index, therefore the internal array starts at 
     * index {@code 1} and ends at index {@code w}.
     * 
     * @param w Maximum size of the binary heap
     */
    public BinaryHeap_Int(int w) {
        this.w = w;
        n = 0;
        this.h = new int[w+1];
    }
    
    /**
     * Rebuilds the binary heap according to the heap structure.
     * 
     * @see dataStructures.BinaryHeap
     */
    public void buildHeapBackwards() {
        int floor = (int) Math.floor(n/2d);
        for (int i=floor; i>0; i--)
            siftDown(i);
    }
    
    @Override
    public void insert(int e) {
        if (n<w) {
            h[++n] = e;
            siftUp(n);
        }
    }

    @Override
    public int deleteMin() {
        int result = h[1];
        h[1] = h[n--];
        siftDown(1);
        return result;
    }

    @Override
    public int min() {
        if (n > 0)
            return h[1];
        throw new NullPointerException(
            "Cannot return minimal element from empty array");
    }
    
    /**
     * Shifts the element at index {@code i} up to maintain
     * the heap property.
     * 
     * @param i Index of the element to shift up
     */
    private void siftUp(int i) {
        int floor = (int) Math.floor(i/2d);
        if (i==1 || h[floor]<=h[i]) 
            return;
        else {
            swap(h, i, floor);
            siftUp(floor);
        }
    }
    
    /**
     * Shifts the element at index {@code i} down to maintain
     * the heap property.
     * 
     * @param i Index of the element to shift down
     */
    private void siftDown(int i) {
        if (2*i<=n) {
            int m;
            if ((2*i+1)>n || h[2*i]<=h[2*i+1])
                m = 2*i;
            else
                m = 2*i+1;
            if (h[i]>h[m]) {
                swap(h, i, m);
                siftDown(m);
            }
        }
    }

    /**
     * Swaps two elements of an array.
     * @param h Array containing the elements to swap
     * @param i Index of the 1st element
     * @param j Index of the 2nd element
     */
    private void swap(int[] h, int i, int j) {
        int temp = h[i];
        h[i] = h[j];
        h[j] = temp;
    }

}
