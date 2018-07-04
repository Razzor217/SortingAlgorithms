package dataStructures;


/**
 * Interface for a binary heap based on integer elements.
 * A heap is a tree-like structure based on the heap property:
 * Child nodes must have smaller priority (= higher key) than
 * parent nodes.
 * 
 * @author Max Beddies
 *
 */
public interface Heap_Int {
    
    /**
     * Inserts a new element into the binary heap and rebuilds
     * the heap according to heap property.
     * @param e Element to be inserted into heap
     */
    public void insert(int e);
    
    /**
     * Deletes and returns the minimal element (root) of the binary
     * heap and rebuilds the heap according to the heap property.
     * @return The root of the binary heap
     */
    public int deleteMin();
    
    /**
     * Returns the minimal element (root) of the binary heap.
     * @return The root of the heap
     */
    public int min();
}
