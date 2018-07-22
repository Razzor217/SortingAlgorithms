#include "MergeSort.h"
#include <math.h>

List* mergeSort(List* list) {
	int n = size(list);
	if(n == 1)
		return list;

	int floor = n/2;
	Node* iter = list->head->next;
	List* left = init_list();
	List* right = init_list();

	int i;
	for (i=0; i<floor; i++, iter = iter->next)
		pushBack(left, iter->value);

	for (i=floor; i<n; i++, iter = iter->next)
		pushBack(right, iter->value);

	return merge(mergeSort(left), mergeSort(right));
}

List* merge(List* left, List* right) {
	List* result = init_list();

	while (!isEmpty(left) && !isEmpty(right)) {
		if (first(left) <= first(right))
			pushBack(result, popFront(left));
		else
			pushBack(result, popFront(right));
	}
	while (!isEmpty(left))
		pushBack(result, popFront(left));
	while (!isEmpty(right))
		pushBack(result, popFront(right));

	free(left);
	free(right);

	return result;
}