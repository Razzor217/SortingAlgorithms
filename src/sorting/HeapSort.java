package sorting;

import java.util.ArrayList;
import java.util.List;

import dataStructures.BinaryHeap;
import dataStructures.Element;

public class HeapSort<T extends Element<K>, K extends Comparable<K>> 
    extends Algorithm {

    private ArrayList<T> list;
    
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
