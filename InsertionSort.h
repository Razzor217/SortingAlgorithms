#ifndef InsertionSort_h
#define InsertionSort_h

/*
 * Excecutes an insertion sort as specified in the class description
 * except it sorts only elements in between index l and r
 * @param a Unsorted array of integers
 * @param l Index of the left-most element
 * @param r Index of the right-most element
 * @param n Length of the array
 * @return 0 if the sorting was successfull, 1 if errors occured
 */
//int insertionSort(int*, int, int, int);
int insertionSort(int* a, int l, int r, int n);

#endif