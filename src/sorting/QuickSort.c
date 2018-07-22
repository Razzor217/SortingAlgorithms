#include "QuickSort.h"

void quickSort(int* a, int l, int r) {
	if (l<r) {
		int k = pickPivot(a, l, r);
		int t = partition(a, l, r, k);
		quickSort(a, l, t-1);
		quickSort(a, t+1, r);
	}
}

int partition(int* a, int l, int r, int k) {
	int p = *(a+k);
	swap(a, k, r);
	int i = l;
	int j;
	for (j=l; j<r; j++) {
		if (*(a+j)<=p) {
			swap(a, i, j);
			i++;
		}
	}
	swap(a, i, r);
	return i;
}

void swap(int* a, int l, int r) {
	int temp = *(a+l);
	*(a+l) = *(a+r);
	*(a+r) = temp;
}

int pickPivot(int* a, int l, int r) {
	return r;
}