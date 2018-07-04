package dataStructures;

import java.util.LinkedList;
import java.util.List;

// TODO: binary heap for integers, fast implementation (without generic code)

/**
 * Implements the heap interface as binary heap (BH).
 * @author Max Beddies
 *
 * @param <T> Type of the value of elements in BH
 * @param <K> Type of the key of elements in BH
 */
public class BinaryHeap<T, K extends Comparable<K>> implements Heap<T, K> {
    
    private LinkedList<Element<T, K>> list;
    private int n;
    
    public BinaryHeap(LinkedList<Element<T, K>> list) {
        this.list = new LinkedList<Element<T, K>>();
        this.list.addAll(list);
        n = 0;
        
        build(this.list);   
    }
    
    public LinkedList<Element<T, K>> getList() { return list; }

    @Override
    public void insert(Element<T, K> element) {
        if (n<size()) {
            list.add(n++, element);
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
        return list.size();
    }

    @Override
    public Element<T, K> min() {
        return list.getFirst();
    }

    @Override
    public void merge(Heap<T, K> heap, Heap<T, K> other) {
        // TODO Auto-generated method stub
        
    }
    
    public void siftUp(int i) {
        /*
        if (i==1 || list.get((int)Math.floor(i/2d)).get<=list.get(i)) {
            
        }
        */
    }
}
