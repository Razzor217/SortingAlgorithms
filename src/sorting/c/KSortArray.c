#include "KSortArray.h"

void kSort(int* a, int n, int K, int (*f)(int, int)) {
	int* b = calloc(n, sizeof(int));
	int* c = calloc(K, sizeof(int));

	// Count number of elements in each bucket and check key generation
	int i;
	for (i=0; i<n; i++) {
		int key = (*f)(*(a+i), K);
		if (key >= 0 && key < K)
			(*(c+key))++;
		else
			return;
	}
	// Transform auxiliary array to contain starting indices of buckets
	int C = 0;
	for (i=0; i<K; i++) {
		int temp = C;
		C = C + *(c+i);
		*(c+i) = temp;
	}
	// Fill buckets with elements and increment starting indeces of buckets
	for (i=0; i<n; i++) {
		*(b + (*(c + (*f)(*(a+i), K)))++) = *(a+i);
	}

	// Refill a with elements from b
	for (i=0; i<n; i++) {
		*(a+i) = *(b+i);
	}

	free(b);
	free(c);
	return;
}