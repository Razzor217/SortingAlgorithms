#ifndef LinkedList_h
#define LinkedList_h

#include <stddef.h>
#include <stdlib.h>

/*
 * A simple list node, containing an integer value, 
 * a pointer to the previous node and a pointer to the next node in the list.
 */
typedef struct node Node;

/*
 * Returns the value of the first element in the list.
 * 		head 		- Node representing the head of the list, a dummy-element
 * 		Returns 	- (-1) if the list is empty
 */
int first(Node* head);

/*
 * Returns the value of the last element in the list.
 *		head 		- Node representing the head of the list
 * 		Returns 	- (-1) if the list is empty
 */
int last(Node* head);

/*
 * Returns 1 if the list is empty, 0 if it is not.
 * 		head 		- Node representing the head of the list
 */
int isEmpty(Node* head);

/*
 * Inserts an integer at the front of the list.
 *		head 		- Node representing the head of the list
 *		a 			- Integer to be inserted at the front of the list
 */
void pushFront(Node* head, int a);

/*
 * Inserts an integer at the back of the list.
 *		head 		- Node representing the head of the list
 *		a 			- Integer to be inserted at the back of the list
 */
void pushBack(Node* head, int a);

/*
 * Retrieves and removes an integer at the front of the list.
 *		head 		- Node representing the head of the list
 * 		Returns		- (-1) if the list is empty.
 */
int popFront(Node* head);

/*
 * Retrieves and removes an integer at the back of the list.
 *		head 		- Node representing the head of the list
 * 		Returns 	- (-1) if the list is empty.
 */
int popBack(Node* head);

#endif