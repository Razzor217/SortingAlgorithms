package sorting;

import dataStructures.BinaryHeap_Int;

public class HeapSort_Int extends Algorithm {
    
    private int[] a;
    
    public HeapSort_Int(int[] a) {
        super();
        setName("Heapsort (binary)");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
        for (int i = 0; i < a.length; i++)
                this.a[i] = a[i];
    }

    @Override
    public void execute() {
        heapSortAsc(a);        
    }

    @Override
    public String toString() {
        return getName() 
            + ":\nArray Length: " 
            + String.format("%,26d", a.length) 
            + "\nElapsed Time: " 
            + String.format("%,23d", getElapsedTime())
            + " ns\n----------------------------------------\n";
    }
    
    public static int[] heapSortDesc(int[] a) {
        BinaryHeap_Int heap = new BinaryHeap_Int(a.length);
        for (int i=0; i<a.length; i++)
            heap.insert(a[i]);
        heap.buildHeapBackwards();
        for (int i=a.length; i>0; i--)
            a[i-1] = heap.deleteMin();
        return a;
    }
    
    public static int[] heapSortAsc(int[] a) {
        BinaryHeap_Int heap = new BinaryHeap_Int(a.length);
        for (int i=0; i<a.length; i++)
            heap.insert(a[i]);
        heap.buildHeapBackwards();
        for (int i=0; i<a.length; i++)
            a[i] = heap.deleteMin();
        return a;
    }

}
