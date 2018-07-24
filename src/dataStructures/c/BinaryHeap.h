#ifndef BinaryHeap_H
#define BinaryHeap_H

#include <stdlib.h>
#include <math.h>

int* init_h(int w);

void buildHeapBackwards(int* h);

void insert_h(int* h, int w, int e);

int deleteMin_h(int* h);

int min(int* h);

void siftUp(int* h, int i);

void siftDown(int* h, int i);

void swap_h(int* h, int i, int j);

#endif