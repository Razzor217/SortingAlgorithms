OBJ = test.o QuickSort_SemiRec.o QuickSort.o KSortArray.o \
	LSDRadixSort.o InsertionSort.o HeapSort.o BinaryHeap.o
PATH = ../../dataStructures/c/

default: test

QuickSort.o: QuickSort.c QuickSort.h
	gcc -c QuickSort.c

QuickSort_SemiRec.o: QuickSort_SemiRec.c QuickSort.h QuickSort_SemiRec.h InsertionSort.h
	gcc -c QuickSort_SemiRec.c

KSortArray.o: KSortArray.c KSortArray.h
	gcc -c KSortArray.c

LSDRadixSort.o: LSDRadixSort.c LSDRadixSort.h KSortArray.h
	gcc -c LSDRadixSort.c

InsertionSort.o: InsertionSort.c InsertionSort.h
	gcc -c InsertionSort.c

BinaryHeap.o: $(PATH)BinaryHeap.c $(PATH)BinaryHeap.h
	gcc -c ../../dataStructures/c/BinaryHeap.c

HeapSort.o: HeapSort.c HeapSort.h $(PATH)BinaryHeap.h
	gcc -c HeapSort.c

test.o: test.c QuickSort.h QuickSort_SemiRec.h LSDRadixSort.h
	gcc -c test.c

test: $(OBJ)

clean: 
	rm -rf test $(OBJ)