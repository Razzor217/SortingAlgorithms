package main;

import java.util.LinkedList;
import java.util.List;

import sorting.Algorithm;
import sorting.BeadSort;
import sorting.BeadSort_Horizontal;
import sorting.InsertionSort;
import sorting.MergeSort_AL;
import sorting.MergeSort_LL;
import sorting.QuickSort;

public class Main {

    // TODO: Add data set to sort
    // TODO: Change algorithm variants to subclasses, override sort
    //       Or even just subclasses of algorithm.
	public static void main(String[] args) {
		
	    int n = 5000000;
	    int range = 1000;
		
		int[] a = new int[n];
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i=0; i<n; i++) {
			int elem = (int)(Math.random()*range+1);
			a[i] = elem;
			list.add(elem);
		}
		
		Algorithm[] b = {
	        //new InsertionSort(a), 
	        //new MergeSort_AL(list),
	        new QuickSort<Integer>(a)//,
	        //new MergeSort_LL(list),
	        //new BeadSort(a),
	        //new BeadSort_Horizontal(a)
	        };
		
		System.out.println("Sum of elements in array: " 
	        + String.format("%,14d", sum(a)));
		System.out.println("Range: " 
	        + String.format("%33s", "[" + 1 + "," + range + "]"));
		System.out.println("Algorithms in ascending order of");
		System.out.println("execution time:");
		System.out.println("----------------------------------------");
		printAlgorithms(b);
		
		/*
		int[] test = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int[] test2 = new int[] {9, 5, 6, 3, 4, 1, 2, 0, 11, 9};
		System.out.println(Arrays.toString(test2));
		QuickSort.quickSort(test2, 0, 9);
		System.out.println(Arrays.toString(test2));
		*/
	}
	
	public static void printAlgorithms(Algorithm[] a) {
	    for (int i=0; i<a.length; i++)
	        a[i].elapsedTime();
	    Algorithm.sort(a);
	    for (int i=0; i<a.length; i++)
	        System.out.print(a[i].toString());
	}
	
	public static long sum(int[] a) {
	    long sum = 0;
	    for (int i=0; i<a.length; i++)
	        sum += a[i];
	    return sum;
	}

}
