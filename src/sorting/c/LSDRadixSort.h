#ifndef LSDRadixSort_H
#define LSDRadixSort_H

#include "KSortArray.h"
#include <math.h>

/*
 * Implements a LSD radix sort on top of {@code KSortArray}. This class
 * maintains a current index of the algoritm which is reset to {@code index=0} 
 * at each execution. The key for an integer a is defined using i as follows: 
 *
 * 		key(a):=(a div B^i) mod B
 *
 * for each digit.
 * Bucket sort is then used to sort the array for each digit, starting 
 * with the least significant digit.
 * Time complexity: O(d*(n+K))
 * 
 *		a 			- The unsorted integer array
 * 		n			- Length of the array
 * 		B 			- Base; number of buckets
 * 		d 			- Number of digits, 
 */
void lsdRadixSort(int* a, int n, int B, int d);

/*
 * Calculates a key for an integer a in the range of {0, ..., B-1}.
 * 		a 			- Integer the key is generated for
 * 		B 			- Base; number of buckets (see lsdRadixSort)
 * 		Returns: 	- A valid key for a
 */
int key(int a, int B);

#endif