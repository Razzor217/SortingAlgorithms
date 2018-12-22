#include "LinkedList.h"

List* init_list() {
    List* list = malloc(sizeof(*list));
    Node* head = malloc(sizeof(*head));
    head->value = 0;
    head->next = NULL;
    list->size = 0;
    list->head = head;
    list->tail = head;

    return list;
}

int size(List* list) {
    return list->size;
}

int first(List* list) {
    if (isEmpty(list))
        return -1;
    return list->head->next->value;
}

int last(List* list) {
    if (isEmpty(list))
        return -1;
    return list->tail->value;
}

int isEmpty(List* list) {
    return size(list) < 1;
}

void pushFront(List* list, int a) {
    Node* element = malloc(sizeof(*element));

    element->value = a;
    element->next = list->head->next;

    if (isEmpty(list))
        list->tail = element;

    list->head->next = element;
    (list->size)++;
}

void pushBack(List* list, int a) {
    Node* element = malloc(sizeof(*element));

    element->value = a;
    element->next = NULL;

    if (isEmpty(list))
        list->head->next = element;

    list->tail->next = element;
    list->tail = element;
    (list->size)++;
}

int popFront(List* list) {
    if (isEmpty(list))
        return -1;
    Node* temp = list->head->next->next;
    int result = list->head->next->value;
    
    free(list->head->next);
    list->head->next = temp;
    (list->size)--;

    return result;
}

int popBack(List* list) {
    if (isEmpty(list))
        return -1;
    Node* current;
    for (current = list->head; current->next != list->tail; current = current->next);
    
    Node* temp = current;
    int result = list->tail->value;

    temp->next = NULL;
    free(list->tail);
    list->tail = temp;
    (list->size)--;

    return result;
}

void printList(List* list) {
    Node* current;
    for (current = list->head->next; current != NULL; current = current->next) {
        printf("%i ", current->value);
    }
    printf("\n");
}

void destroy(List* list) {
    while(!isEmpty(list))
        popFront(list);
}