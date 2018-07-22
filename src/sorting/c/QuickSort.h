#ifndef QuickSort_H
#define QuickSort_H

/*
 * Implements quick sort on arrays of integers.
 * Quicksort divides any sequence integers into three parts:
 * 
 *     	1. sequence containing objects smaller than pivot
 *      2. pivot element
 *      3. sequence containing objects greater than or equal to pivot
 *
 * The same algorithm is then applied to sequences 1 and 3 which builds the 
 * recursion of quick sort.
 * Time complexity: O(n*log n)
 *
 * 		a 	- Unsorted integer array
 * 		l 	- Index of the left-most array element
 * 		r 	- Index of the right-most array element
 */
void quickSort(int* a, int l, int r);

/*
 * Partitions the array into three parts by swapping all elements 
 * which are smaller than the pivot element to the left of the pivot 
 * element.
 *  	a 	- The unsorted array
 * 		l 	- Index of the left-most element 
 * 		r 	- Index of the right-most element
 * 		k 	- Index of the pivot element
 * 		return: Index of the pivot element, determines bounds of next recursion
 */
int partition(int* a, int l, int r, int k);

/*
 * Swaps two elements of an array
 * 		a 	- Array containing both integers
 * 		l 	- Index of the 1st integer
 * 		r 	- Index of the 2nd integer
 */
void swap(int* a, int l, int r);

/*
 * Chooses the index of the pivot element
 * 		a 	- Unsorted array
 * 		l 	- Left bound of the array
 *  	r  	- Right bound of the array
 * 		return: The index of the pivot element
 */
int pickPivot(int* a, int l, int r);

#endif