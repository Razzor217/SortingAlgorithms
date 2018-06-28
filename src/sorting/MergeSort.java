package sorting;

import java.util.ArrayList;

public class MergeSort extends Algorithm {

    private ArrayList<Integer> a;
    
    public MergeSort(ArrayList<Integer> a) {
        super();
        setName("Merge Sort");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new ArrayList<Integer>();
        for (int i=0; i<a.size(); i++)
            this.a.add(a.get(i));
    }
    
    @Override
    public void execute() {
        mergeSort(a);
        
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> a) {
        
        return a;
    }

}
