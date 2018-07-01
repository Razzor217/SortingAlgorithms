package sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Implements merge sort on integer array lists and linked lists.
 *
 * Mergesort sorts a list by recursively separating the list into 
 * two halves and merging them into a sorted list, for example:
 *  List:   {3, 2, 6, 4, 7, 8, 0, 1}
 *      1.  {3, 2, 6, 4} {7, 8, 0, 1}       (split)
 *      2.  {3, 2} {6, 4} {7, 8} {0, 1}     (split)
 *      3.  {3} {2} {6} {4} {7} {8} {0} {1} (split)
 *      4.  {2, 3} {4, 6} {7, 8} {0, 1}     (merge)
 *      5.  {2, 3, 4, 6} {0, 1, 7, 8}       (merge)
 *      6.  {0, 1, 2, 3, 4, 6, 7, 8}        (merge)
 *      
 * mergeSort() splits and builds the recursion, 
 * merge() merges the two lists into one sorted list.
 */
public class MergeSort_AL extends Algorithm {

    private ArrayList<Integer> a;
    
    
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
    
    /*
     * Array list has O(1) for retrieving elements etc, 
     * but O(1*) (amortized) for adding new elements
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
