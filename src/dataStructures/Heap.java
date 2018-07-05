package dataStructures;

/**
 * Interface for a generic heap, extends a priority queue by the operations
 * {@code build}, {@code size}, {@code min} and {@code merge}.
 * A heap extends a PQ to a tree structure where the smallest element
 * is at the root of the tree.
 * The tree is constructed so that the heap property holds:
 *      The key of parent nodes must be smaller (= higher priority) than 
 *      the key of all its child nodes.
 *      
 * For convenience, the first entry of the underlying array list is not used;
 * instead, the list spans from index {@code 1} to index {@code n} where 
 * {@code n} is the length of the input list.
 * 
 * @author Max Beddies
 *
 * @param <T> Type of the elements in the heap
 * @param <K> Type of the keys of elements in the heap
 */
public interface Heap<T extends Element<K>, K extends Comparable<K>> 
    extends PriorityQueue<T, K> {
    
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
     * @param other Binary heap to be merged with
     */
    public void merge(Heap<T, K> other);
}
