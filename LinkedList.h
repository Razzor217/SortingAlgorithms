#ifndef LinkedList_h
#define LinkedList_h

typedef struct node Node;

/*
 * Returns the value of the first element in the list.
 * Returns NULL if the list is empty.
 */
int first(void);

/*
 * Returns the value of the last element in the list.
 * Returns NULL if the list is empty.
 */
int last(void);

/*
 * Returns 1 if the list is empty, 0 if it is not.
 */
int isEmpty(void);

/*
 * Inserts an integer at the front of the list.
 * Returns 1 on success, 0 on failure.
 */
int pushFront(int);

/*
 * Inserts an integer at the back of the list.
 * Returns 1 on success, 0 on failure.
 */
int pushBack(int);

/*
 * Retrieves and removes an integer at the front of the list.
 * Returns NULL if the list is empty.
 */
int popFront(void);

/*
 * Retrieves and removes an integer at the back of the list.
 * Returns NULL if the list is empty.
 */
int popBack(void);

#endif