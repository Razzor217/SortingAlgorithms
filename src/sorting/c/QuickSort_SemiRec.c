#include "QuickSort_SemiRec.h"

void quickSort_SemiRec(int* a, int l, int r, int n) {
	if (l<r) {
        while (r-l+1 > n) {
            int k = pickPivot(a, l, r);
            int m = partition(a, l, r, k);
            int floor = n / 2;
            // Use quick sort recursively only on smaller part of the array
            if (m<floor) {
                quickSort_SemiRec(a, l, m-1, n);
                l = m+1;
            } else {
                quickSort_SemiRec(a, m+1, r, n);
                r = m-1;
            }
        }
        insertionSort(a, l, r);
    }
}