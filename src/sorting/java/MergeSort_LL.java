package sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implements merge sort on top of a linked list. Merge sort divides the list
 * recursively into halves until there are only lists containing one element 
 * (which are considered sorted) and then merges them recursively into sorted 
 * lists.<p>
 * A linked list is used because of access to {@code head} and {@code tail} 
 * in {@code O(1)} as well as insertions after the last element and removal 
 * of the first element in {@code O(1)}.<p>
 * Time complexity: {@code O(n*log n)}
 * 
 * @author Max Beddies
 *
 */
/*
 * Example:
 * List:    {3, 2, 6, 4, 7, 8, 0, 1}
 *      1.  {3, 2, 6, 4} {7, 8, 0, 1}       (split)
 *      2.  {3, 2} {6, 4} {7, 8} {0, 1}     (split)
 *      3.  {3} {2} {6} {4} {7} {8} {0} {1} (split)
 *      4.  {2, 3} {4, 6} {7, 8} {0, 1}     (merge)
 *      5.  {2, 3, 4, 6} {0, 1, 7, 8}       (merge)
 *      6.  {0, 1, 2, 3, 4, 6, 7, 8}        (merge)
 */
public class MergeSort_LL extends Algorithm {
    
    private LinkedList<Integer> list;
    
    /**
     * Initializes merge sort with an unsorted list containing integers.
     * @param a The unsorted list
     */
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

    /**
     * Executes a merge sort as specified in the class description.
     * @param a The unsorted list
     * @return The sorted list
     */
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> a) {
        
        if (a.size()==1)
            return a;
        
        int n = a.size();
        LinkedList<Integer> left = new LinkedList<Integer>();
        LinkedList<Integer> right = new LinkedList<Integer>();
        Iterator<Integer> it = a.iterator();
        
        for (int i=0; i<(int)Math.floor(n/2d); i++)
           left.addLast(it.next());
        for (int i=(int)Math.floor(n/2d); i<n; i++)
            right.addLast(it.next());
        
        return merge(mergeSort(left), mergeSort(right));
    }
    
    /**
     * Merges two lists {@code left} and {@code right} into one sorted list 
     * by comparing the first elements of both lists and inserting the smaller 
     * one to the end of a resulting list until one list is empty and then 
     * adding all elements of the other list.
     * @param left The left list to merge
     * @param right The right list to merge
     * @return The resulting sorted list
     */
    public static LinkedList<Integer> merge(
            LinkedList<Integer> left, 
            LinkedList<Integer> right) {
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        while (!left.isEmpty() && !right.isEmpty()) {
            if(left.getFirst() <= right.getFirst())
                result.addLast(left.removeFirst());
            else
                result.addLast(right.removeFirst());
        }
        while (!left.isEmpty())
            result.addLast(left.removeFirst());
        while (!right.isEmpty())
            result.addLast(right.removeFirst());
            
        return result;
    }
}
