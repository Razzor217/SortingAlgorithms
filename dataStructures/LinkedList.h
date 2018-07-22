#ifndef LinkedList_h
#define LinkedList_h

#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>

/*
 * Implements a singly linked list which opts for constant time complexity for 
 * the following functions:
 * 		- size
 * 		- isEmpty
 * 		- first
 * 		- last
 * 		- pushFront
 *		- pushBack
 * 		- popFront
 * The function popBack 
 */

/*
 * A singly linked list node, containing an integer value
 * and a pointer to the next node in the list.
 */
typedef struct node Node;

/*
 * A singly linked list, 
 * contains a pointer to the fist node and a pointer to the last node.
 */
typedef struct list List;

/*
 * Initializes the first node of the list and returns the list.
 * 		a 			- integer value of the first element
 */
List* init(int a);

/*
 * Returns the number of elements in the list.
 * 		list 		- Pointer to the list
 */
int size(List* list);

/*
 * Returns the value of the first element in the list.
 * 		list 		- Pointer to the list
 * 		Returns 	- (-1) if the list is empty
 */
int first(List* list);

/*
 * Returns the value of the last element in the list.
 *		list 		- Pointer to the list
 * 		Returns 	- (-1) if the list is empty
 */
int last(List* list);

/*
 * Returns 1 if the list is empty, 0 if it is not.
 * 		list 		- Pointer to the list
 */
int isEmpty(List* list);

/*
 * Inserts an integer at the front of the list.
 *		list 		- Pointer to the list
 *		a 			- Integer to be inserted at the front of the list
 */
void pushFront(List* list, int a);

/*
 * Inserts an integer at the back of the list.
  *		list 		- Pointer to the list
 *		a 			- Integer to be inserted at the back of the list
 */
void pushBack(List* list, int a);

/*
 * Retrieves and removes an integer at the front of the list.
  *		list 		- Pointer to the list
 * 		Returns		- (-1) if the list is empty.
 */
int popFront(List* list);

/*
 * Retrieves and removes an integer at the back of the list.
  *		list 		- Pointer to the list
 * 		Returns 	- (-1) if the list is empty.
 */
int popBack(List* list);


/*
 * Prints all elements of a given list.
  *		list 		- Pointer to the list
 */
void printList(List* list);

#endif