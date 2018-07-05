package sorting;

public abstract class KSortArray extends Algorithm {

    private int[] a;
    protected int K;
    
    public KSortArray(int[] a, int K) {
        super();
        setName("Bucket Sort");
        this.K = K;
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
        for (int i=0; i<a.length; i++)
            this.a[i] = a[i];
    }
    
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
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
    
    public int[] kSort(int[] a) {
        int n = a.length;
        int[] c = new int[K];
        int[] b = new int[n];
        
        // Count number of elements in each bucket
        for (int i=0; i<n; i++)
            c[key(a[i])]++;
        // Transform auxiliary array to contain indices of buckets
        int C = 0;
        for (int k=0; k<K; k++) {
            int temp = C;
            C = C+c[k];
            c[k] = temp;
        }
        // Fill buckets
        for (int i=0; i<n; i++)
            b[c[key(a[i])]++] = a[i];
        return b;
    }
    
    public abstract int calculateKey(int a);
    
    private int key(int a) {
        int key = calculateKey(a);
        if (key < 0 || key > K)
            throw new IllegalArgumentException("Error, key not within range");
        return key;
    }

}
