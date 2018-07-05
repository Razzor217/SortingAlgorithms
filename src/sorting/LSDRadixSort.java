package sorting;

public class LSDRadixSort extends KSortArray {

    private int d;
    private int index;
    
    public LSDRadixSort(int[] a, int K, int d) {
        super(a, K);
        setName("LSD Radix Sort");
        this.d = d;
        index = 0;
    }

    @Override
    public void execute() {
        lsdRadixSort(a);
    }
    
    @Override
    public int calculateKey(int a) {
        return a / (int) Math.pow(K, index);
    }
    
    public int[] lsdRadixSort(int[] a) {
        index = 0;
        while(index<d) {
            a = kSort(a);
            index++;
        }
        return a;
    }
}
