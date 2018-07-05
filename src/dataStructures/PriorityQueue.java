package dataStructures;

/**
 * Interface for an addressable priority queue.
 * Each element of type {@code Element<T, K>} has a (within the PQ) 
 * unique key of type {@code K}.
 * The PQ is ordered by key (ascending).
 * 
 * @author Max Beddies
 * 
 * @param <T> Type of the elements in the PQ
 * @param <K> Type of the key of  elements in the PQ
 */
public interface PriorityQueue<T extends Element<K>, K extends Comparable<K>> {

    /**
     * Inserts a new element into the PQ, sorted by {@code key}.
     * @param element New Element of type {@code T}.
     */
    public void insert(T element);
    
    /**
     * Removes an element with key {@code key} from the PQ 
     * and rebuilds the PQ. 
     * @param key Key of the element to be removed
     * @return The removed element
     */
    public T remove(K key);
    
    /**
     * Deletes and returns the element with smallest key.
     * Rebuilds PQ after removal.
     * @return The element with smallest key.
     */
    public T deleteMin();
    
    /**
     * Decreases the key of a given element in the PQ 
     * and rebuilds the PQ.
     * @param element Element to decrease key of
     * @param key New key of {@code element}
     */
    public void decreaseKey(T element, K key);
}
