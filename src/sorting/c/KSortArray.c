#include "KSortArray.h"

int* kSort(int* a, int n, int K, int (*f)(int)) {
	int* c = calloc(K, sizeof(int));
	int* b = calloc(n, sizeof(int));
	// Count number of elements in each bucket and check key generation
	int i;
	for (i=0; i<n; i++) {
		int key = (*f)(*(a+i));
		if (key >= 0 && key < K)
			*(c+key)++;
		else
			return NULL;
	}
	// Transform auxiliary array to contain starting indices of buckets
	int C = 0;
	for (i=0; i<K; k++) {
		int temp = C;
		C = C + *(c+i);
		*(c+i) = temp;
	}
	// Fill buckets with elements and increment starting indeces of buckets
	for (i=0; i<n; i++) {
		*(b + *(c + (*f)(*(a+i)))++);
	}
	free(c);
	return b;
}