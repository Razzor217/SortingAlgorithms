package main;

import java.util.ArrayList;
import java.util.Arrays;

import sorting.Algorithm;
import sorting.BeadSort;
import sorting.InsertionSort;

public class Main {

	public static void main(String[] args) {
		int n = 10000;
		int[] a = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			int elem = (int)(Math.random()*10000+1);
			a[i] = elem;
			list.add(elem);
		}
		
		Algorithm[] b = {new InsertionSort(a), new BeadSort(a)};
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
