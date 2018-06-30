package sorting;

import java.util.Arrays;

/*
 * Implements Bead Sort on a simple array of positive integers.
 * The algorithm is explained below.
 */
public class BeadSort extends Algorithm {

    private int[] a;

    public BeadSort(int[] a) {
        super();
        setName("Bead Sort");
        setVariants(2);
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
    public void execute(int k) {
        switch (k) {
        case 1:
            beadSort(a);
            break;
        case 2:
            beadSort_Horizontal(a);
        default:
            beadSort(a);
        }
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

    /*
     * Executes a bead sort on a given array of positive integers. 
     * Each number is represented by that many beads in one row on different 
     * vertically aligned posts. These are then sorted by letting the beads 
     * 'fall down' on their respective post, for example: 
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
    public static int[] beadSort(int[] a) {
        int n = a.length;
        int max = 0;

        // Calculate maximum element, O(n)
        for (int i = 0; i < n; i++) {
            if (a[i] >= max)
                max = a[i];
        }
        // Initialize beads
        int[][] beads = new int[n][max];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < max; j++) {
                if (j < a[i])
                    beads[i][j] = 1;
                else
                    beads[i][j] = 0;
            }
        }

        for (int j = 0; j < max; j++) {
            int sum = 0;
            // Count beads on post
            for (int i = 0; i < n; i++) {
                sum += beads[i][j];
                beads[i][j] = 0;
            }
            // Drop beads
            for (int i = n - sum; i < n; i++) {
                beads[i][j] = 1;
            }
        }

        // Put sorted values in array using beads
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < max && beads[i][j] == 1; j++)
                ;
            a[i] = j;
        }
        
        return a;
    }
    
    /*
     * Executes a bead sort on a given array of positive integers. 
     * Each number is represented by that many beads in one column on different 
     * horizontally aligned posts. These are then sorted by letting the beads 
     * 'fall down' (vertically) on their respective post, for example: 
     * The array {4, 1, 6, 2, 3, 1, 4} first unsorted and then sorted 
     * represented on beads: 
     *  
     *    0 1 2 3 4 5 6       0 1 2 3 4 5 6
     *  0 * * * * * * *     0 * * * * * * *
     *  1 * - * * * - *     1 --- * * * * *
     *  2 * - * - * - *  => 2 ----- * * * *
     *  3 * - * ----- *     3 ------- * * *
     *  4 --- * -------     4 ----------- *
     *  5 --- * -------     5 ----------- *
     *  
     *     {4,1,6,2,3,1,4}  {1,1,2,3,4,4,6}
     */
    public static int[] beadSort_Horizontal(int[] a) {
        
        int n = a.length;
        
        // get greatest element
        int max = 0;
        for (int i=0; i<n; i++) {
            if (a[i]>=max)
                max = a[i];
        }
        // Each column represents one positive integer of the original array
        int[][] beads = new int[max][n];
        // Initialize beads
        for (int i=0; i<max; i++) {
            for (int j=0; j<n; j++) {
                if (i<a[j])
                    beads[i][j] = 1;
                else
                    beads[i][j] = 0;
            }
        }
        //printMatrix(beads);
        for (int i=0; i<max; i++) {
            int sum = 0;
            // Count beads on each post
            for (int j=0; j<n; j++) {
                sum += beads[i][j];
                beads[i][j] = 0;
            }
            // 'Drop' beads via (vertical) gravity
            for (int j=n-sum; j<n; j++)
                beads[i][j] = 1;
        }
        //printMatrix(beads);
        //System.out.println(max);
        // Refill array
        for (int j=0; j<n; j++) {
            int i;
            for (i=0; i<max && beads[i][j]==1; i++);
            a[j] = i;
        }
        return a;
    }
    
    public static void printMatrix(int[][] a) {
        for (int i=0; i<a.length; i++)
            System.out.println(Arrays.toString(a[i]));
    }

}
