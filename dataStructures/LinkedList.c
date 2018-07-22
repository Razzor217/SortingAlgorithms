#include "LinkedList.h"

struct node {
	int value;
	Node* next;
	Node* prev;
};

Node* init() {
	Node* head;
	
	head = malloc(sizeof(Node));
	
	head->value = 0;
	head->next = head;
	head->prev = head;

	return head;
}

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
	if (head == NULL || head->next == NULL)
		return 1;
	return 0;
}

void pushFront(Node* head, int a) {
	Node* element;
	Node* tail = head->prev;

	element = malloc(sizeof(Node));

	element->value = a;
	element->next = head;
	element->prev = tail;

	tail->next = element;
	head->prev = element;
	head = element;
}

void pushBack(Node* head, int a) {
	Node* element;
	Node* tail = head->prev;
	
	element = malloc(sizeof(Node));

	element->value = a;
	element->next = head;
	element->prev = tail;

	tail->next = element;
	head->prev = element;
}

int popFront(Node* head) {
	if (isEmpty(head))
		return -1;
	int result = head->value;
	
	Node* temp = head;
	temp->prev->next = temp->next;
	temp->next->prev = temp->prev;
	
	head = temp->next;
	free(temp);
	
	return result;
}

int popBack(Node* head) {
	if (isEmpty(head))
		return -1;
	Node* tail = head->prev;
	int result = tail->value;

	Node* temp = tail;
	temp->prev->next = temp->next;
	temp->next->prev = temp->prev;

	head->prev = temp->prev;
	free(temp);

	return result;
}

void printList(Node* head) {
	Node* current;
	for (current = head->next; current != head; current = current->next) {
		printf("%i ", current->value);
	}
	printf("\n");
}