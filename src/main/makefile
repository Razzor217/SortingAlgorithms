OBJ = BinaryHeap.o HeapSort.o InsertionSort.o KSortArray.o \
	LinkedList.o LSDRadixSort.o MergeSort.o QuickSort.o \
	QuickSort_SemiRec.o Main.o
	
PATH_DATA = ../dataStructures/c/
PATH_SORT = ../sorting/c/

default: main

BinaryHeap.o: $(PATH_DATA)BinaryHeap.c $(PATH_DATA)BinaryHeap.h
	gcc -c $(PATH_DATA)BinaryHeap.c

HeapSort.o: $(PATH_SORT)HeapSort.c $(PATH_SORT)HeapSort.h $(PATH_DATA)BinaryHeap.h
	gcc -c $(PATH_SORT)HeapSort.c

InsertionSort.o: $(PATH_SORT)InsertionSort.c $(PATH_SORT)InsertionSort.h
	gcc -c $(PATH_SORT)InsertionSort.c

KSortArray.o: $(PATH_SORT)KSortArray.c $(PATH_SORT)KSortArray.h
	gcc -c $(PATH_SORT)KSortArray.c

LinkedList.o: $(PATH_DATA)LinkedList.c $(PATH_DATA)LinkedList.h
	gcc -c $(PATH_DATA)LinkedList.c

LSDRadixSort.o: $(PATH_SORT)LSDRadixSort.c $(PATH_SORT)LSDRadixSort.h \
 	$(PATH_SORT)KSortArray.h
	gcc -c $(PATH_SORT)LSDRadixSort.c

MergeSort.o: $(PATH_SORT)MergeSort.c $(PATH_SORT)MergeSort.h $(PATH_DATA)LinkedList.h
	gcc -c $(PATH_SORT)MergeSort.c

QuickSort.o: $(PATH_SORT)QuickSort.c $(PATH_SORT)QuickSort.h
	gcc -c $(PATH_SORT)QuickSort.c

QuickSort_SemiRec.o: $(PATH_SORT)QuickSort_SemiRec.c $(PATH_SORT)QuickSort_SemiRec.h \
	$(PATH_SORT)QuickSort.h $(PATH_SORT)InsertionSort.h
	gcc -c $(PATH_SORT)QuickSort_SemiRec.c

Main.o: Main.c $(PATH_SORT)HeapSort.h $(PATH_SORT)InsertionSort.h \
	$(PATH_SORT)LSDRadixSort.h $(PATH_SORT)MergeSort.h $(PATH_SORT)QuickSort.h \
	$(PATH_SORT)QuickSort_SemiRec.h
	gcc -c Main.c

main: $(OBJ)
	gcc -o main $(OBJ)

clean: 
	rm -rf main $(OBJ)