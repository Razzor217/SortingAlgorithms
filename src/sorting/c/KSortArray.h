#ifndef KSortArray_H
#define KSortArray_H

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
 * Note: kSort returns a pointer to a new array, i.e. memory is allocated and needs
 * to be freed afterwards.
 * Time complexity: {@code O(n+K)}
 *		a 			- The unsorted integer array
 * 		n 			- Length of the array
 *		K 			- The number of available buckets
 * 		(*f)		- A function which takes an integer and returns a key in the 
 * 					  range of {0,...,K-1}
 * 		Returns: 	- A pointer to the new sorted array
 *					- NULL if any key was not within range
 */
int* kSort(int* a, int n, int K, int (*f)(int));

#endif