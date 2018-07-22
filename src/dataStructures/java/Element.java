package dataStructures;

/**
 * Assigns a key of type {@code K} to an object.
 * 
 * @author Max Beddies
 *
 * @param <K> Type of the key of an element
 */
public interface Element<K extends Comparable<K>> {
    
    public K getKey();
    public void setKey(K key);
}
