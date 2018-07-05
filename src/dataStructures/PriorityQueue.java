package dataStructures;

import java.util.List;

/**
 * Interface for a generic addressable priority queue.
 * Each element of type {@code T} has a (within the PQ) 
 * unique key of type {@code K}.
 * The PQ is ordered by key (ascending).
 * 
 * For convenience, the data structure of the PQ is ordered by {@code key}
 * but addressed by {@code index} (Still, as it is sorted, {@code find} 
 * operations could be implemented in {@O(log n)} complexity).
 * 
 * @author Max Beddies
 * 
 * @param <T> Type of the elements in the PQ
 * @param <K> Type of the key of  elements in the PQ
 */
public interface PriorityQueue<T extends Element<K>, K extends Comparable<K>> {

    /**
     * Returns the underlying data structure of the PQ as a list.
     * @return The underlying PQ.
     */
    public List<T> getList();
    /**
     * Inserts a new element into the PQ, sorted by {@code key}.
     * The PQ is rebuilt as necessary.<p>
     * Time complexity: {@code O(log n)}
     * @param element New Element of type {@code T}.
     */
    public void insert(T element);
    
    /**
     * Removes an element with key {@code key} from the PQ 
     * and rebuilds the PQ.<p>
     * Time complexity: {@code O(log n)}
     * @param index Index of the element to be removed
     * @return The removed element
     */
    public T remove(int index);
    
    /**
     * Deletes and returns the element with smallest key.
     * Rebuilds PQ after removal.<p>
     * Time complexity: {@code O(log n)}
     * @return The element with smallest key.
     */
    public T deleteMin();
    
    /**
     * Decreases the key of a given element in the PQ 
     * and rebuilds the PQ.<p>
     * Time complexity: {@code O(log n)}
     * @param index Index of the element to decrease key of
     * @param key New key of {@code element}
     */
    public void decreaseKey(int index, K key);
}
