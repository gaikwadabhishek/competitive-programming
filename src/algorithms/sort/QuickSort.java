package algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while(true) {
			while(less(a[++i], a[lo])) 
				if(i == hi) break;
			while(less(a[lo], a[--j]))
				if(j == lo) break;
			if(i >= j) break;
			exchg(a, i, j);
		}
		exchg(a, lo, j);
		return j;
	}
	
	private static void exchg (Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0 ;
	}
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi<=lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j+1, hi);
	}
	
	public static void main(String[] args) {
		Comparable[] a = {1,4,2,8,3,5,0,9,6,7};
		QuickSort.sort(a);
	 	System.out.println(a);
	} 
}
