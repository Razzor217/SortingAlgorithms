package sorting;

import java.util.Arrays;

/**
 * Implements another variant of horizontal bead sort which uses 
 * the difference between the smallest and the greatest element as 
 * matrix size to minimize computation time and space.
 * 
 * @see BeadSort_Horizontal
 * 
 * @author Max Beddies
 *
 */
/*
 * Example: {9, 6, 11, 7, 8, 6, 9}
 * 
 *    0 1 2 3 4 5 6       0 1 2 3 4 5 6
 *  0 * * * * * * *     0 * * * * * * *
 *  1 * * * * * * *     1 * * * * * * *
 *  2 * * * * * * *     2 * * * * * * *
 *  3 * * * * * * *     3 * * * * * * *
 *  4 * * * * * * *     4 * * * * * * *
 *                  ==>
 *  5 * * * * * * *     5 * * * * * * *
 *  6 * - * * * - *     6 - - * * * * *
 *  7 * - * - * - *     7 - - - * * * *
 *  8 * - * - - - *     8 - - - - * * *
 *  9 - - * - - - -     9 - - - - - - *
 * 10 - - * - - - -    10 - - - - - - * 
 * 
 * Sorted: {6, 6, 7, 8, 9, 9, 11}
 * 
 * Only rows 5 to 10 are transformed into a matrix, rows 0 to 4 do not change
 */
public class BeadSort_Diff extends Algorithm {
    private int[] a;

    /**
     * Initializes bead sort with an array of integers.
     * @param a The array to be sorted
     * @throws NullPointerException If input array is not initialized
     * @throws IllegalArgumentException If input array contains non 
     * positive values
     */
    public BeadSort_Diff(int[] a) {
        super();
        setName("Bead Sort (Difference)");
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
        int min = min(a);
        int diff = max(a) - min;
        
        // Each column represents one positive integer of the original array
        int[][] beads = new int[diff][n];
        // Initialize beads
        for (int i=0; i<diff; i++)
            for (int j=0; j<n; j++)
                if (i<a[j]-min)
                    beads[i][j] = 1;
                
        for (int i=0; i<diff; i++) {
            int sum = 0;
            // Count beads on each post
            for (int j=0; j<n; j++) {
                sum += beads[i][j];
                beads[i][j] = 0;
            }
            // 'Drop' beads via (horizontal) gravity
            for (int j=n-sum; j<n; j++)
                beads[i][j] = 1;
        }
        
        // Refill array
        for (int j=0; j<n; j++) {
            int i;
            for (i=0; i<diff && beads[i][j]==1; i++);
            a[j] = i + min;
        }
        return a;
    }
        
    /**
     * Computes the greatest element of an array of integers.
     * {@code max} starts at {@code max = 1} because all elements need to
     * be positive in bead sort.
     * @param a The underlying array
     * @return The greatest element
     */
    public static int max(int[] a) {
        int max = 1;
        for (int i=0; i<a.length; i++)
            if (a[i]>=max)
                max = a[i];
        return max;
    }
    
    /**
     * Computes the smallest element of an array of integers.
     * {@code max} starts at {@code max = 1} because all elements need to
     * be positive in bead sort.
     * @param a The underlying array
     * @return The smallest element
     */
    public static int min(int[] a) {
        int min = 1;
        for (int i=0; i<a.length; i++)
            if (a[i]<=min)
                min = a[i];
        return min;
    }

}
