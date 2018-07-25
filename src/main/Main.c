#include <stdio.h>
#include <stdlib.h>

#include <time.h>

#include "../sorting/c/HeapSort.h"
#include "../sorting/c/InsertionSort.h"
#include "../sorting/c/LSDRadixSort.h"
#include "../sorting/c/MergeSort.h"
#include "../sorting/c/QuickSort.h"
#include "../sorting/c/QuickSort_SemiRec.h"

#include "../dataStructures/c/LinkedList.h"

void printArray(int*, int);
long elapsedTime(int*, List*, int, int, int, int);
char* getName(int);
void fillArray(int*, int*, int);

int main() {
	int n = 200;
	int d = 3;
	int k = 5;
	int* a = calloc(n, sizeof(int));
	int* b = calloc(n, sizeof(int));
	List* list = init_list();
	int i;
	for (i=0; i<n; i++) {
		*(a+i) = n-i;
		pushBack(list, n-1);
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// TODO: Fix Heapsort and Mergesort
//////////////////////////////////////////////////////////////////////////////////////////
	
	for (i=0; i<8; i++) {
		fillArray(a, b, n);
		printf("%s:\n", getName(i));
		printf("Elapsed time: %'ld ns\n", elapsedTime(b, list, i, n, d, k));
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

long elapsedTime(int* a, List* list, int algorithm, int n, int d, int k) {
	struct timespec start, end;
	long elapsedTime;
	switch (algorithm) {
		case 0:
		// Heap sort, ascending
		clock_gettime(CLOCK_REALTIME, &start);
		heapSort_asc(a, n-1);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 1:
		// Heap sort, descending
		clock_gettime(CLOCK_REALTIME, &start);
		heapSort_desc(a, n-1);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 2:
		// Insertion sort
		clock_gettime(CLOCK_REALTIME, &start);
		insertionSort(a, 0, n-1);
		clock_gettime(CLOCK_REALTIME, &end);
		case 3:
		// LSD radix sort, base 2
		clock_gettime(CLOCK_REALTIME, &start);
		lsdRadixSort(a, n, 2, d);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 4:
		// LSD radix sort, base 4
		clock_gettime(CLOCK_REALTIME, &start);
		lsdRadixSort(a, n, 4, d);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 5:
		// LSD radix sort, base 10
		clock_gettime(CLOCK_REALTIME, &start);
		lsdRadixSort(a, n, 10, d);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 6:
		// Mergesort
		clock_gettime(CLOCK_REALTIME, &start);
		mergeSort(list);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 7:
		// Quicksort
		clock_gettime(CLOCK_REALTIME, &start);
		quickSort(a, 0, n-1);
		clock_gettime(CLOCK_REALTIME, &end);
		break;
		case 8:
		// Quicksort, semi recursive with insertion sort
		clock_gettime(CLOCK_REALTIME, &start);
		quickSort_SemiRec(a, 0, n-1, k);
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
		name = "Heap sort (asc)";
		break;
		case 1:
		name = "Heap sort (desc)";
		break;
		case 2:
		name = "Insertion sort";
		break;
		case 3:
		name = "LSD radix sort, base 2";
		break;
		case 4:
		name = "LSD radix sort, base 4";
		break;
		case 5:
		name = "LSD radix sort, base 10";
		break;
		case 6:
		name = "Mergesort";
		break;
		case 7:
		name = "Quicksort";
		break;
		case 8:
		name = "Quicksort, semi recursive";
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

	/* 
	TEST LIST FUNCTIONALITY

	
	printList(list);

	printf("List size: %i\n", size(list));

	popFront(list);
	popFront(list);
	popFront(list);
	printList(list);

	pushFront(list, 33);
	printList(list);

	pushBack(list, 33);
	printList(list);

	popBack(list);
	printList(list);

	popFront(list);
	printList(list);

	pushFront(list, 18);
	pushFront(list, 19);
	pushFront(list, 20);
	printList(list);
	
	printf("------------------------\n");
	*/