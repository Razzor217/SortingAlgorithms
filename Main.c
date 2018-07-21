#include <stdio.h>
#include <stdlib.h>

#include "InsertionSort.h"

void print(int*, int n);

int main() {

	int n = 10;
	int* a = calloc(n, sizeof(int));
	int i;
	// Create sample data
	for (i=0; i<n; i++)
		a[i] = n-i-1;

	print(a, n);

	if (insertionSort(a, 0, n-1, n))
		return 1;

	print(a, n);

	free(a);
	return 0;
}

void print(int* a, int n) {
	int i;
	for (i=0; i<n; i++)
		if (i<n-1)
			printf("%i, ", a[i]);
		else
			printf("%i\n", a[i]);
}