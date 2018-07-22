#ifndef QuickSort_SemiRec_H
#define QuickSort_SemiRec_H

#include "QuickSort.h"
#include "InsertionSort.h"

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
 * This recursion is used until the smaller partitions reach length n; at this point
 * the algorithm switches to insertion sort which is faster for small list sizes.
 * Time complexity: O(n*log n)
 *
 * 		a 	- Unsorted integer array
 * 		l 	- Index of the left-most array element
 * 		r 	- Index of the right-most array element
 * 		n 	- array length at which to switch to insertion sort
 */
void quickSort_SemiRec(int* a, int l, int r, int n);

#endif