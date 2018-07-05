package dataStructures;

/**
 * Interface for a generic heap, extends a priority queue (PQ) by the 
 * operations {@code size}, {@code min} and {@code merge}.
 * A heap extends a PQ to a tree-like structure where the smallest element
 * is at the root of the tree.<p>
 * The tree is constructed so that the heap property holds:<p>
 *      The key of parent nodes must be smaller (= higher priority) than 
 *      the key of all its child nodes.<p>
 * For convenience, the first entry of the underlying array list is not used;
 * instead, the list spans from index {@code 1} to index {@code n} where 
 * {@code n} is the length of the input list.
 * 
 * @author Max Beddies
 *
 * @param <T> Type of the elements in the heap
 * @param <K> Type of the keys of elements in the heap
 */
/*
 * Example:
 *  (1)     1          (2)   5
 *         / \              / \
 *        2   3            6   10
 *       / \              /  
 *      4   5            14 
 *  {1, 2, 3, 4, 5}    {5, 6, 10, 14}
 *
 *   (1), (2) are valid binary heaps (with {@code n=5}/{@code n=4} elements.
 */
public interface Heap<T extends Element<K>, K extends Comparable<K>> 
    extends PriorityQueue<T, K> {
    
    /**
     * Returns the length of the underlying PQ.<p>
     * Time complexity: {@code O(1)}
     * @return The length of the underlying PQ.
     */
    public int size();
    
    /**
     * Returns the element with smallest key without removing it 
     * from the PQ.<p>
     * Time complexity: {@code O(1)}
     * @return The smallest element of the heap
     */
    public T min();
    
    /**
     * Merges two heaps by merging the underlying PQs and rebuilding the 
     * heap.<p>
     * Time complexity: {@code O(n)}
     * @param other Binary heap to be merged with
     */
    public void merge(Heap<T, K> other);
}
