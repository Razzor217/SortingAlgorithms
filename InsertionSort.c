#include "InsertionSort.h"

int insertionSort(int* a, int l, int r) {
	int i;
	for (i=l; i<r+1; i++) {
		int e = *(a+i);
		int j = i;
		while (j>0 && *(a+j-1)>e) {
			*(a+j) = *(a+j-1);
			j--;
		}
		*(a+j) = e;
	}
	return 0;
}