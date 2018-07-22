package sorting;

import java.util.ArrayList;
import java.util.List;

import dataStructures.BinaryHeap;
import dataStructures.Element;

/**
 * Implements a generic heap sort on top of a generic binary heap.
 * Heap sort continuously calls {@code deleteMin()} on the binary heap to
 * remove the smallest element from the heap and add it into a list.<p>
 * The underlying data structure is an array list, to get constant access time.
 * Time complexity: {@code O(n*log n)}
 * 
 * @see dataStructures.PriorityQueue
 * @see dataStructures.Heap
 * @see dataStructures.BinaryHeap
 * 
 * @author Max Beddies
 *
 * @param <T> Type of the elements contained in the binary heap
 * @param <K> Type of the keys of elements in the binary heap
 */
public class HeapSort<T extends Element<K>, K extends Comparable<K>> 
    extends Algorithm {

    private ArrayList<T> list;
    
    /**
     * Initializes heap sort with a list containing elements of type {@code T}.
     * @param list The list to be sorted
     * @throws NullPointerException If input list is not initialized
     */
    public HeapSort(List<T> list) {
        super();
        setName("Heapsort (binary)");
        if (list.isEmpty())
            throw new NullPointerException(
                "Error, cannot sort empty list");
        this.list = new ArrayList<T>();
        this.list.addAll(list);
    }

    @Override
    public void execute() {
        heapSort(list);        
    }

    @Override
    public String toString() {
        return getName() 
            + ":\nArray Length: " 
            + String.format("%,26d", list.size()) 
            + "\nElapsed Time: " 
            + String.format("%,23d", getElapsedTime())
            + " ns\n----------------------------------------\n";
    }
    
    /**
     * Executes a heap sort as specified in the class description
     * @param list The unsorted list
     * @return The sorted list
     */
    public List<T> heapSort(ArrayList<T> list) {
        BinaryHeap<T, K> heap = new BinaryHeap<>(list.size());
        for (T elem : list)
            heap.insert(elem);
        heap.buildHeapBackwards();
        for (int i=0; i<list.size(); i++)
            list.set(i, heap.deleteMin());
        return list;
    }
}
