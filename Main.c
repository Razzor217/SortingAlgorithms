#include <stdio.h>
#include <stdlib.h>

#include "algorithms/InsertionSort.h"
#include "dataStructures/LinkedList.h"

void print(int*, int n);

int main() {

	int n = 20;
	int* a = calloc(n, sizeof(int));
	int i;
	List* list = init(n);
	// Create sample data
	for (i=0; i<n; i++)
		a[i] = n-i-1;
	for (i=1; i<n; i++)
		pushBack(list, n-i);

	//print(a, n);
	
	printf("List:\n");
	printList(list);

	printf("----------------------------------------\n");
	
	popFront(list);
	popFront(list);
	popFront(list);
	
	printf("List:\n");
	printList(list);

	printf("----------------------------------------\n");

	pushBack(list, 128);

	printf("List:\n");
	printList(list);

	printf("----------------------------------------\n");

	pushFront(list, 128);

	printf("List:\n");
	printList(list);
	
	printf("----------------------------------------\n");

	popBack(list);

	printf("List:\n");
	printList(list);
	
	printf("----------------------------------------\n");

	popFront(list);

	printf("List:\n");
	printList(list);
	
	printf("----------------------------------------\n");

	pushFront(list, 18);
	pushFront(list, 19);
	pushFront(list, 20);

	printf("List:\n");
	printList(list);
	
	printf("----------------------------------------\n");

	/*
	if (!insertionSort(a, 0, n-1))
		return EXIT_FAILURE;
	print(a, n);
	*/
	free(a);
	return 0;
}

/* 
 * Prints an array of integers with given length.
 * @param a The integer array
 * @param n The length of the array (count of elements)
 */
void print(int* a, int n) {
	int i;
	for (i=0; i<n; i++)
		printf("%i ", *(a+i));
	printf("\n");
}