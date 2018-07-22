package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import sorting.Algorithm;
import sorting.BeadSort;
import sorting.BeadSort_Diff;
import sorting.BeadSort_Horizontal;
import sorting.HeapSort_Int;
import sorting.InsertionSort;
import sorting.LSDRadixSort;
import sorting.MergeSort_AL;
import sorting.MergeSort_LL;
import sorting.QuickSort;
import sorting.QuickSort_SemiRec;

public class Main {

	public static void main(String[] args) {
		
	    int n = 5000000;
	    int range = 2;
		
		int[] a = new int[n];
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i=0; i<n; i++) {
			int elem = (int)(Math.random()*range+1);
			a[i] = elem + 100;
			list.add(elem);
		}
		
		Algorithm[] b = {
	        //new InsertionSort(a), 
	        //new MergeSort_AL(list),
	        //new QuickSort(a),
	        //new MergeSort_LL(list),
	        //new BeadSort(a),
	        new BeadSort_Horizontal(a),
		    //new HeapSort_Int(a),
		    //new LSDRadixSort(a, 10, (int) Math.log10(range) + 1),
		    //new LSDRadixSort(a, 4, (int) Math.log10(range) + 1),
		    //new LSDRadixSort(a, 2, (int) Math.log10(range) + 1),
		    //new QuickSort_SemiRec(a, 10),
	        new BeadSort_Diff(a)
	        };
		
		System.out.println("Sum of elements in array: " 
	        + String.format("%,14d", sum(a)));
		System.out.println("Range: " 
	        + String.format("%33s", "[" + 1 + "," + range + "]"));
		System.out.println("Algorithms in ascending order of");
		System.out.println("execution time:");
		System.out.println("========================================");
		printAlgorithms(b);
		
		/*
		int[] test = new int[] {9+10, 8+10, 7+10, 6+10, 5+10, 
		        4+10, 3+10, 2+10, 1+10, 0+10};
		int[] test2 = new int[] {9+5, 5+5, 6+5, 3+5, 4+5,
		        1+5, 2+5, 0+5, 11+5, 9+5};
		BeadSort_Diff.beadSort(test2);
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
