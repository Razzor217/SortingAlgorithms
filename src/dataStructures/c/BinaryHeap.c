#include "BinaryHeap.h"

int* init_h(int w) {
	int* h = calloc(w+1, sizeof(int));
	*h = 0;
	return h;
}

void buildHeapBackwards(int* h) {
	int floor = *h / 2;
	int i;
	for (i=0; i<floor; i--)
		siftDown(h, i);
}

void insert_h(int* h, int w, int e) {
	if ((*h)<w) {
		*(h + (++(*h))) = e;
		siftUp(h, *h);
	}
}

int deleteMin_h(int* h) {
	int result = *(h+1);
	*(h+1) = *(h + ((*h)--));
	siftDown(h, 1);
	return result;
}

int min(int* h) {
	if ((*h)>0)
		return *(h+1);
	else
		return -1;
}

void siftUp(int* h, int i) {
	int floor = i / 2;
	if (i==1 || (*(h+floor))<=(*(h+i)))
		return;
	else {
		swap_h(h, i, floor);
		siftUp(h, floor);
	}
}

void siftDown(int* h, int i) {
	if (2*i<=(*h)) {
		int m;
		if ((2*i+1)>(*h) || (*(h+2*i))<=(*(h+2*i+1)))
			m = 2*i;
		else
			m = 2*i+1;
		if ((*(h+i))>(*(h+m))) {
			swap_h(h, i, m);
			siftDown(h, m);
		}
	}
}

void swap_h(int* h, int i, int j) {
	int temp = *(h+i);
	*(h+i) = *(h+j);
	*(h+j) = temp;
}