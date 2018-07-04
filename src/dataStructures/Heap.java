package dataStructures;

import java.util.List;

/**
 * Interface for a heap, extends a priority queue by the operations
 * {@code build}, {@code size}, {@code min} and {@code merge}.
 * A heap extends a PQ to a tree structure where the smallest element
 * is at the root of the tree.
 * 
 * @author Max Beddies
 *
 * @param <T> Type of the elements in the heap
 * @param <K> Type of the keys of elements in the heap
 */
public interface Heap<T, K> extends PriorityQueue<T, K>{

    /**
     * Initially builds a heap from a list of elements of type {@code T}.
     * @param list List of elements to build the heap from
     */
    public void build(List<T> list);
    
    /**
     * Returns the length of the underlying PQ.
     * @return The length of the underlying PQ.
     */
    public int size();
    
    /**
     * Returns the element with smallest key without removing it 
     * from the PQ.
     * @return The smallest element of the heap
     */
    public T min();
    
    /**
     * Merges two heaps by merging the underlying PQs and rebuilding the heap.
     * @param heap First heap to be merged with
     * @param other Second heap to be merged with
     */
    public void merge(Heap<T, K> heap, Heap<T, K> other);
}
