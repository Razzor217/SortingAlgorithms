package dataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// TODO: binary heap for integers, fast implementation (without generic code)

/**
 * Implements the heap interface as binary heap (BH).
 * @author Max Beddies
 *
 * @param <T> Type of the value of elements in BH
 * @param <K> Type of the key of elements in BH
 */
public class BinaryHeap<T, K extends Comparable<K>> implements Heap<T, K> {
    
    private Vector<Element<T, K>> h;
    private int n;
    
    public BinaryHeap(int w) {
        this.h = new Vector<Element<T, K>>(w);
        n = 0;
        build(this.h);   
    }
    
    public LinkedList<Element<T, K>> getVector() { return h; }

    @Override
    public void insert(Element<T, K> element) {
        if (n<size()) {
            h.add(n++, element);
            siftUp(n);
        }
    }

    @Override
    public Element<T, K> remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Element<T, K> deleteMin() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void decreaseKey(Element<T, K> element, K key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void build(List<Element<T, K>> list) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        return h.size();
    }

    @Override
    public Element<T, K> min() {
        return h.firstElement();
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
