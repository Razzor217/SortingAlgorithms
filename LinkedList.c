#include "LinkedList.h"

struct node {
	int value;
	Node* prev;
	Node* next;
};

int first(Node* head) {
	if (!isEmpty(head))
		return head->value;
	return -1;
}

int last(Node* head) {
	if (!isEmpty(head))
		return head->prev->value;
	return -1;
}

int isEmpty(Node* head) {
	if (head == NULL)
		return 1;
	return 0;
}

void pushFront(Node* head, int a) {
	Node* node = malloc(sizeof(Node));

	node->value = a;
	node->prev = head->prev;
	node->next = head;

	head = node;
}

void pushBack(Node* head, int a) {
	Node* node = malloc(sizeof(Node));

	node->value = a;
	node->prev = head->prev;
	node->next = NULL;

	head->prev = node;
}

int popFront(Node* head) {
	//TODO
	return 1;
}