package sorting;

/*
 * Implements Bead Sort on a simple array of positive integers.
 */
public class BeadSort extends Algorithm {
	
	private int[] a;
	
	public BeadSort(int[] a) {
		super();
		this.setName("Bead Sort");
		this.a = new int[a.length];
		for (int i=0; i<a.length; i++) {
			if (a[i]>0)
				this.a[i] = a[i];
			else
				throw new 
		}
	}

	@Override
	public void execute() {
		beadSort(a);
	}

	@Override
	public String toString() {
		
		return null;
	}
	
	public static int[] beadSort(int[] a) {
		if (a == null)
			throw new NullPointerException(
				"Error, cannot initialize from null array");
		int n = a.length;
		int max = 0;
		
		// Calculate maximum element, O(n)
		for (int i=0; i<n; i++) {
			if (a[i] >= max)
				max = a[i];
		}
		// Initialize beads
		int[][] beads = new int[n][max];
		for (int i=0; i<n; i++) {
			for (int j=0; j<max; j++) {
				if (j<a[i])
					beads[i][j] = 1;
				else
					beads[i][j] = 0;
			}
		}
		
		for (int j=0; j<max; j++) {
			int sum = 0;
			// Count beads on post
			for (int i=0; i<n; i++) {
				sum += beads[i][j];
				beads[i][j] = 0;
			}
			// Drop beads
			for (int i=n-sum; i<n; i++) {
				beads[i][j] = 1;
			}
		}
		
		// Put sorted values in array using beads
		for (int i=0; i<n; i++) {
			int j;
			for (j=0; j<max && beads[i][j]==1; j++);
			a[i] = j;
		}
		
		return a;
	}

}
