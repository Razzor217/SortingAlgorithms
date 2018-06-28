package main;

import java.util.LinkedList;
import java.util.List;

import sorting.Algorithm;
import sorting.BeadSort;
import sorting.InsertionSort;
import sorting.MergeSort;

public class Main {

	public static void main(String[] args) {
		int n = 2000;
		int[] a = new int[n];
		List<Integer> list = new LinkedList<Integer>();
		for (int i=0; i<n; i++) {
			int elem = (int)(Math.random()*50+1);
			a[i] = elem;
			list.add(elem);
		}
		
		Algorithm[] b = {new InsertionSort(a), 
	        new MergeSort(list),
	        new BeadSort(a)};
		System.out.println("Sum of all elements in array: " + sum(a));
		System.out.println("Algorithms in ascending order of");
		System.out.println("execution time:");
		System.out.println("----------------------------------------");
		printAlgorithms(b);
	}
	
	public static void printAlgorithms(Algorithm[] a) {
	    for (int i=0; i<a.length; i++)
	        a[i].elapsedTime();
	    Algorithm.sort(a);
	    for (int i=0; i<a.length; i++)
	        System.out.print(a[i].toString());
	}
	
	public static int sum(int[] a) {
	    int sum = 0;
	    for (int i=0; i<a.length; i++)
	        sum += a[i];
	    return sum;
	}

}
