#ifndef InsertionSort_h
#define InsertionSort_h

/*
 * Excecutes an insertion sort as specified in the class description
 * except it sorts only elements in between index l and r
 * 		a - Unsorted array of integers
 * 		l - Index of the left-most element
 * 		r - Index of the right-most element
 * Returns 1 if the sorting was successfull, 0 if errors occured
 */
int insertionSort(int* a, int l, int r);

#endif