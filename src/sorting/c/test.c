#include <stdio.h>
#include <stdlib.h>

#include <time.h>
#include <locale.h>

#include "InsertionSort.h"
#include "LSDRadixSort.h"
#include "QuickSort.h"
#include "QuickSort_SemiRec.h"

void printArray(int*, int);
long elapsedTime(int*, int, int, int, int);
char* getName(int);
void fillArray(int*, int*, int);

int main() {
	int n = 200;
	int d = 3;
	int k = 5;
	int* a = calloc(n, sizeof(int));
	int* b = calloc(n, sizeof(int));
	int i;
	for (i=0; i<n; i++)
		*(a+i) = n-i;

	for (i=0; i<6; i++) {
		fillArray(a, b, n);
		printf("%s:\n", getName(i));
		printf("Elapsed time: %'ld ns\n", elapsedTime(b, i, n, d, k));
	}

	free(a);
	free(b);
	return 0;
}

void printArray(int* a, int n) {
	int i;
	for (i=0; i<n; i++)
		printf("%i ", *(a+i));
	printf("\n");
}

long elapsedTime(int* a, int algorithm, int n, int d, int k) {
	struct timespec start, end;
	long elapsedTime;
	switch (algorithm) {
		case 0:
		// Quicksort
		clock_gettime(CLOCK_REALTIME, &start);
		quickSort(a, 0, n-1);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 1:
		// Quicksort, semi recursive with insertion sort
		clock_gettime(CLOCK_REALTIME, &start);
		quickSort_SemiRec(a, 0, n-1, k);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 2:
		// LSD radix sort, base 2
		clock_gettime(CLOCK_REALTIME, &start);
		lsdRadixSort(a, n, 2, d);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 3:
		// LSD radix sort, base 4
		clock_gettime(CLOCK_REALTIME, &start);
		lsdRadixSort(a, n, 4, d);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 4:
		// LSD radix sort, base 10
		clock_gettime(CLOCK_REALTIME, &start);
		lsdRadixSort(a, n, 10, d);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 5:
		// Insertion sort
		clock_gettime(CLOCK_REALTIME, &start);
		insertionSort(a, 0, n-1);
		clock_gettime(CLOCK_REALTIME, &end);
		break;

		default: 
		elapsedTime = 0; 
		break;
	}
	elapsedTime = end.tv_nsec - start.tv_nsec;
	return elapsedTime;
}

char* getName(int algorithm) {
	char* name;
	switch (algorithm) {
		case 0:
		name = "Quicksort";
		break;
		case 1:
		name = "Quicksort, semi recursive";
		break;
		case 2:
		name = "LSD radix sort, base 2";
		break;
		case 3:
		name = "LSD radix sort, base 4";
		break;
		case 4:
		name = "LSD radix sort, base 10";
		break;
		case 5:
		name = "Insertion sort";
		break;

		default: 
		name = NULL;
		break;
	}
	return name;
}

void fillArray(int* a, int* b, int n) {
	int i;
	for (i=0; i<n; i++)
		*(b+i) = *(a+i);
}