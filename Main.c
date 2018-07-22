#include <stdio.h>
#include <stdlib.h>

#include "algorithms/InsertionSort.h"
#include "dataStructures/LinkedList.h"

void print(int*, int n);

int main() {

	int n = 20;
	int* a = calloc(n, sizeof(int));
	int i;
	// Create sample data
	for (i=0; i<n; i++)
		a[i] = n-i-1;

	print(a, n);
	if (!insertionSort(a, 0, n-1))
		return EXIT_FAILURE;
	print(a, n);

	free(a);
	return 0;
}

/* 
 * Prints an array of integers with given length.
 * @param a The integer array
 * @param n The length of the array (count of elements)
 */
void print(int* a, int n) {
	int i;
	for (i=0; i<n; i++)
		if (i<n-1)
			printf("%i, ", *(a+i));
		else
			printf("%i\n", *(a+i));
}