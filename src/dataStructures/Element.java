package dataStructures;

/**
 * Assigns a key of type {@code K} to an object of type {@code T}.
 * 
 * @author Max Beddies
 *
 * @param <T> Type of the element
 * @param <K> Type of the key of an element
 */
public interface Element<K extends Comparable<K>> {
    
    public K getKey();
    public void setKey(K key);
}
