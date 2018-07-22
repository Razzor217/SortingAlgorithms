package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a merge sort on top of an array list containing integers.
 * <p>
 * Array lists have index access in constant time, but addition of new 
 * elements only in amortized constant time.
 * 
 * @see sorting.MergeSort_LL
 * 
 * @author Max Beddies
 *
 */
public class MergeSort_AL extends Algorithm {

    private ArrayList<Integer> a;
    
    /**
     * Initializes merge sort with an unsorted list of integers.
     * @param a The unsorted list
     */
    public MergeSort_AL(List<Integer> a) {
        super();
        setName("Mergesort (Arraylist)");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new ArrayList<Integer>();
        this.a.addAll(a);
    }
    
    @Override
    public void execute() {
        mergeSort(a);
    }

    @Override
    public String toString() {
        return getName()
            + ":\nList Length: "
            + String.format("%,27d", a.size())
            + "\nElapsed Time: " 
            + String.format("%,23d", getElapsedTime())
            + " ns\n----------------------------------------\n";
    }
    
    /**
     * Executes merge sort as specified in {@code MergeSort_LL}
     * 
     * @see sorting.MergeSort_LL
     * 
     * @param a The unsorted list
     * @return The sorted list
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
        if (a.size()==1)
            return a;
        int n = a.size();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        
        for (int i=0; i<(int)Math.floor(n/2d); i++)
            left.add(a.get(i));
        for (int i=(int)Math.floor(n/2d); i<n; i++)
            right.add(a.get(i));
        
        return merge(mergeSort(left), mergeSort(right));
    }
    
    /**
     * Merges two lists as specified in {@code MergeSort_LL}
     * 
     * @see sorting.MergeSort_LL#merge(LinkedList, LinkedList)
     * 
     * @param left The left list to merge
     * @param right The right list to merge
     * @return The sorted merged list
     */
    public static ArrayList<Integer> merge(
            ArrayList<Integer> left, 
            ArrayList<Integer> right) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while (!left.isEmpty() && !right.isEmpty()) {
            if(left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        while (!left.isEmpty()) {
            result.add(left.get(0));
            left.remove(0);
        }
        while (!right.isEmpty()) {
            result.add(right.get(0));
            right.remove(0);
        }
        
        return result;
    }
}
