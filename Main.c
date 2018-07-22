#include <stdio.h>
#include <stdlib.h>

#include "algorithms/InsertionSort.h"
#include "algorithms/MergeSort.h"
#include "dataStructures/LinkedList.h"

void print(int*, int n);

int main() {

	int n = 20;
	int* a = calloc(n, sizeof(int));
	int i;
	List* list = init_list();
	// Create sample data
	for (i=0; i<n; i++)
		a[i] = n-i-1;
	for (i=0; i<n; i++)
		pushBack(list, n-i);

	/* TEST LIST FUNCTIONALITY */
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

	print(a, n);
	if (!insertionSort(a, 0, n-1))
		return EXIT_FAILURE;
	print(a, n);
	
	destroy(list);
	free(list);
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