package sorting;

/**
 * Implements a LSD radix sort on top of {@code KSortArray}. This class
 * maintains a current index of the algoritm which is reset to {@code index=0} 
 * at each execution. The key for an integer {@code a} is defined using 
 * {@code index} as<p> 
 * {@code key:=(a div K^index) mod K}<p>
 * for each digit. {@code KSortArray} 
 * is then used to sort the array for each digit using bucket sort, starting 
 * with the least significant digit.<p>
 * Time complexity: {@code O(d*(n+K))}
 * 
 * @see sorting.KSortArray
 * 
 * @author Max Beddies
 *
 */
public class LSDRadixSort extends KSortArray {

    private int d;
    private int index;
    
    /**
     * Initializes LSD sort with an integer array, amount of buckets and
     * number of digits used to generate keys.
     * @param a The unsorted integer array
     * @param K The amount of buckets
     * @param d The number of digits
     */
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
        return (a / (int) Math.pow(K, index)) % K;
    }
    
    /**
     * Executes bucket sort for each digit, i.e. LSD radix sort.
     * @param a The unsorted array
     * @return The sorted array
     */
    public int[] lsdRadixSort(int[] a) {
        index = 0;
        while(index<d) {
            a = kSort(a);
            index++;
        }
        return a;
    }
}
