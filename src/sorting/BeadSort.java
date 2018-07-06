package sorting;

/**
 * Implements a bead sort on a given array of positive integers. 
 * Each number is represented by that many beads in one row on different 
 * vertically aligned posts. These are then sorted by letting the beads 
 * 'fall down' on their respective post.<p>
 * Time complexity: {@code O(n*max{elem : elem\in a})}
 * 
 * @author Max Beddies
 */
/* Example: 
 * The array {4, 1, 6, 2, 3, 1, 4} first unsorted and then sorted 
 * represented on beads: 
 *        0 1 2 3 4 5      0 1 2 3 4 5
 *      0 * * * * | |    0 * | | | | |
 *      1 * | | | | |    1 * | | | | |
 *      2 * * * * * *    2 * * | | | |
 *      3 * * | | | | => 3 * * * | | |
 *      4 * * * | | |    4 * * * * | |
 *      5 * | | | | |    5 * * * * | |
 *      6 * * * * | |    6 * * * * * *
 * 
 *     {4,1,6,2,3,1,4}  {1,1,2,3,4,4,6}
 */
public class BeadSort extends Algorithm {

    private int[] a;
    
    /**
     * Initializes bead sort with an array of integers.
     * @param a The array to be sorted
     * @throws NullPointerException If input array is not initialized
     * @throws IllegalArgumentException If input array contains non 
     * positive values 
     */
    public BeadSort(int[] a) {
        super();
        setName("Bead Sort");
        if (a == null)
            throw new NullPointerException(
                "Error, cannot sort null array");
        this.a = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                this.a[i] = a[i];
            else
                throw new IllegalArgumentException(
                    "Error, only positive integers allowed with bead sort");
        }
    }

    @Override
    public void execute() {
        beadSort(a);
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

    /**
     * Executes a bead sort as specified in the class description.
     * @param a Array to be sorted
     * @return The sorted array
     */
    public static int[] beadSort(int[] a) {
        int n = a.length;
        int max = 0;

        // Calculate maximum element, O(n)
        for (int i = 0; i < n; i++)
            if (a[i] >= max)
                max = a[i];
        
        // Initialize beads
        int[][] beads = new int[n][max];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < max; j++)
                if (j < a[i])
                    beads[i][j] = 1;

        for (int j = 0; j < max; j++) {
            int sum = 0;
            // Count beads on post
            for (int i = 0; i < n; i++) {
                sum += beads[i][j];
                beads[i][j] = 0;
            }
            // Drop beads
            for (int i = n - sum; i < n; i++)
                beads[i][j] = 1;
        }

        // Put sorted values in array using beads
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < max && beads[i][j] == 1; j++);
            a[i] = j;
        }
        
        return a;
    }
}
