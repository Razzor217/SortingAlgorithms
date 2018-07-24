#include "HeapSort.h"

void heapSort_desc(int* a, int n) {
	int* h = init_h(n);
	int i;
	for (i=0; i<n; i++)
		insert(h, *(a+i));
	// Just to be sure
	buildHeapBackwards(h);
	for (i=n; i>0; i--)
		*(a+i-1) = deleteMin_h(h);
	free(h);
	return a;
}

void heapSort_asc(int* a, int n) {
	int* h = init_h(n);
	int i;
	for (i=0; i<n; i++)
		insert(h, *(a+i));
	// Just to be sure
	buildHeapBackwards(h);
	for (i=0; i<n; i++)
		*(a+i) = deleteMin_h(h);
	free(h);
	return a;
}