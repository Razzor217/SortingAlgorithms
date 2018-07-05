package dataStructures;

import java.util.ArrayList;
import java.util.List;

// TODO: binary heap for integers, fast implementation (without generic code)

/*
 * Notes:
 *  - all comparison operations now operate on key
 *  - all operations on array/list indices still operate on indices
 *  - element becomes interface
 */

/**
 * Implements the heap interface as binary heap (BH).
 * @author Max Beddies
 *
 * @param <T> Type of the value of elements in BH
 * @param <K> Type of the key of elements in BH
 */
public class BinaryHeap<T extends Element<K>, K extends Comparable<K>> 
    implements Heap<T, K> {
    
    private ArrayList<T> h;
    private int n;
    
    public BinaryHeap(int w) {
        this.h = new ArrayList<T>(w);
        n = 0;
        build(this.h);   
    }

    @Override
    public void insert(T element) {
        if (n<size()) {
            h.add(n++, element);
            siftUp(n);
        }
    }

    @Override
    public T remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T deleteMin() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void decreaseKey(T element, K key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void build(List<T> list) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        return h.size();
    }

    @Override
    public T min() {
        return h.get(1);
    }

    @Override
    public void merge(Heap<T, K> heap, Heap<T, K> other) {
        // TODO Auto-generated method stub
        
    }
    
    public void siftUp(int i) {
        int floor = (int) Math.floor(i/2d);
        if (i==1 || h.get(floor).getKey()
            .compareTo(h.get(i).getKey())<=0) {
            
        }
    }
    
    public void swap() {}
}
