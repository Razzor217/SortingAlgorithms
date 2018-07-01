package sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeSort_LL extends Algorithm {
    
    private LinkedList<Integer> list;
    
    public MergeSort_LL(List<Integer> a) {
        super();
        setName("Mergesort (Linked List)");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        list = new LinkedList<Integer>();
        list.addAll(a);
    }
    
    @Override
    public void execute() {
        mergeSort(list);
    }

    @Override
    public String toString() {
        return getName()
            + ":\nList Length: "
            + String.format("%,27d", list.size())
            + "\nElapsed Time: " 
            + String.format("%,23d", getElapsedTime())
            + " ns\n----------------------------------------\n";
    }

    /*
     * Linked list has O(n) for retrieving elements 
     * but O(1) for adding and removing elements at 
     * the front/end of the list
     */
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> a) {
        
        if (a.size()==1)
            return a;
        
        int n = a.size();
        LinkedList<Integer> left = new LinkedList<Integer>();
        LinkedList<Integer> right = new LinkedList<Integer>();
        Iterator<Integer> it = a.iterator();
        
        for (int i=0; i<(int)Math.floor(n/2d); i++)
           left.add(it.next());
        for (int i=(int)Math.floor(n/2d); i<n; i++)
            right.add(it.next());
        
        return merge(mergeSort(left), mergeSort(right));
    }
    
    public static LinkedList<Integer> merge(
            LinkedList<Integer> left, 
            LinkedList<Integer> right) {
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        while (!left.isEmpty() && !right.isEmpty()) {
            if(left.get(0) <= right.get(0))
                result.add(left.removeFirst());
            else
                result.add(right.removeFirst());
        }
        while (!left.isEmpty())
            result.add(left.removeFirst());
        while (!right.isEmpty())
            result.add(right.removeFirst());
            
        return result;
    }
}
