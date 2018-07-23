#ifndef KSortArray_H
#define KSortArray_H

#include <stdlib.h>

/*
 * Implements a bucket sort on top of an integer array.
 *
 * For a given amount of buckets K, elements get assigned a key in the 
 * range of {0,...,K-1}. In an auxiliary array, the number of elements for 
 * each bucket is counted and then transformed into indices for the resulting
 * array, i.e. the auxiliary array holds the starting indices for each bucket.
 *
 * The resulting array is then refilled using the indices in the auxiliary 
 * arrax.
 * This variant refills the original array at the end of the calculations 
 * which is slower but more space efficient.
 * Time complexity: O(n+K)
 *		a 			- The unsorted integer array
 * 		n 			- Length of the array
 *		K 			- The number of available buckets
 * 		(*f)		- A function which takes two integers a and K and returns 
 *					  key(a) in the range of {0,...,K-1}
 * 	Aborts execution if a key value was not within range.
 */
void kSort(int* a, int n, int K, int (*f)(int, int));

#endif