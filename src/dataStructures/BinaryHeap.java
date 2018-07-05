package dataStructures;

import java.util.ArrayList;

/**
 * Implements the heap interface as generic binary heap (BH).<p>
 * An array list with elements of type {@code T} is used to guarantee 
 * constant access time as long as {@code size()} is less than 
 * {@code capacity}.
 * 
 * @see dataStructures.Heap
 * @see dataStructures.PriorityQueue
 * @see java.util.ArrayList
 * 
 * @author Max Beddies
 *
 * @param <T> Type of elements in BH
 * @param <K> Type of the key of elements in BH
 */
public class BinaryHeap<T extends Element<K>, K extends Comparable<K>> 
    implements Heap<T, K> {
    
    /**
     * Generic array list the binary heap is built upon
     */
    private ArrayList<T> h;
    /**
     * Index of the last element in the binary heap
     */
    private int n;
    /**
     * Maximum size of the binary heap
     */
    private int w;
    
    /**
     * Initializes a new heap with given maximum size {@code w}.
     * For easier checking of heap properties, the internal array list is 
     * shifted by one index, therefore the internal array list starts at 
     * index {@code 1} and ends at index {@code w}.
     * <p>
     * Initializes the array list with {@code null} since insertions are 
     * implemented as overwrites, instead of adding new list entries.
     * 
     * @param w Maximum size of the binary heap
     */
    public BinaryHeap(int w) {
        this.w = w;
        n = 0;
        this.h = new ArrayList<T>(w+1);
        for (int i=0; i<=w; i++)
            h.add(null);
    }
    
    /**
     * Returns the array list the binary heap is built upon
     * @return The underlying array list of type {@code T}
     */
    public ArrayList<T> getList() { return h; }
    
    /**
     * Constructs (or reconstructs) the binary heap to maintain the 
     * heap property.<p>
     * Shifts all elements down the heap if needed, starting from 
     * the parent node of index {@code n}, ending with index {@ode 1}.
     * 
     * @see dataStructures.Heap
     */
    public void buildHeapBackwards() {
        int floor = (int) Math.floor(n/2d);
        for (int i=floor; i>0; i--)
            siftDown(i);
    }

    @Override
    public void insert(T element) {
        if (n<w) {
            h.set(++n, element);
            siftUp(n);
        }
    }

    @Override
    public T remove(int index) {
        if (n>0) {
            T result = h.get(index);
            h.set(index, h.get(n--));
            siftDown(index);
            return result;
        } else
            throw new NullPointerException(
                "Cannot remove minimal element from emtpy array");
    }

    @Override
    public T deleteMin() {
        if (n>0) {
            T result = h.get(1);
            h.set(1, h.get(n--));
            siftDown(1);
            return result;
        } else
            throw new NullPointerException(
                "Cannot remove minimal element from emtpy array");
    }

    @Override
    public void decreaseKey(int index, K key) {
        if (h.get(index).getKey().compareTo(key)<=0) {
            h.get(index).setKey(key);
            siftUp(index);
        }       
    }

    @Override
    public int size() {
        return h.size();
    }

    @Override
    public T min() {
        if (n>0)
            return h.get(1);
        else
            throw new NullPointerException(
                "Cannot return minimal element from empty array");
    }

    @Override
    public void merge(Heap<T, K> other) {
        h.addAll(other.getList());
        n+=other.getList().size();
        buildHeapBackwards();
    }
    
    /**
     * Shifts the element at index {@code i} up the binary heap if needed
     * to maintain the heap property.<p>
     * Time complexity: {@code O(log n)}
     * 
     * @param i Index of the element to be shifted up
     * 
     * @see dataStructures.Heap
     */
    private void siftUp(int i) {
        int floor = (int) Math.floor(i/2d);
        if (i==1 || h.get(floor).getKey().compareTo(h.get(i).getKey())<=0)
            return;
        swap(h, i, floor);
        siftUp(floor);
    }
    
    /**
     * Shifts the element at index {@code i} down the binary heap if needed
     * to maintain the heap property.<p>
     * Time complexity: {@code O(log n)}
     * 
     * @param i Index of the element to be shifted down
     * 
     * @see dataStructures.Heap
     */
    private void siftDown(int i) {
        if (2*i<=n) {
            int m;
            if (2*i+1>n || 
                h.get(2*i).getKey().compareTo(h.get(2*i+1).getKey())<=0)
                m = 2*i;
            else
                m = 2*i+1;
            if (h.get(i).getKey().compareTo(h.get(m).getKey())>0) {
                swap(h, i, m);
                siftDown(m);
            }
        }
    }
    
    /**
     * Swaps two elements of a list which are of type {@code T}.<p>
     * Time complexity: {@code O(1)}
     * 
     * @param list List containing the elements to swap
     * @param i Index of the 1st element
     * @param j Index of the 2nd element
     */
    private void swap(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
