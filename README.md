# SortingAlgorithms
Implements various sorting algorithms in `Java` (and, if specified, in `C`) and compares 
their time complexity. Each algorithm extends the `Algorithm` base class 
(`src/sorting/Algorithm`) which provides basic functionality for calculations of the 
execution time, comparisons and printing of algorithms.  
All algorithms which are implemented here to date are sorting algorithms. Some of these 
require specialized data structures, 
e.g. `HeapSort` which is built upon `BinaryHeap`. These data structures are located in 
`src/dataStructures`.  
So far, the following algorithms have been implemented:  
1. `Bead sort` (gravity sort, vertical, horizontal and difference variant)
2. `Heap sort` (`Java`: generic variant and integer variant, `C`: integer variant)
3. `Insertion sort` (`Java`, `C`)
4. `Bucket sort` (`Java`: abstract, `C`)
5. `LSD radix sort` (`Java`, `C`)
6. `Merge sort` (`Java`, `C`: array list variant and linked list variant)
7. `Quick sort` (`Java`, `C`: normal and semi recursive variant which uses insertion  
sort for small list sizes)

If not specified differently, these algorithms work on arrays / lists of integers to 
increase performance.
