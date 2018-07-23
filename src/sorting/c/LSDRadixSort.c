#include "LSDRadixSort.h"

int i;

void lsdRadixSort(int* a, int n, int B, int d) {
	i = 0;
	while (i<d) {
		kSort(a, n, B, key);
		i++;
	}
}

int key(int a, int B) {
	return (a / ((int) pow(B, i))) % B;
}