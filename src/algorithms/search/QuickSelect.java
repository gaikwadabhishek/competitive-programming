package algorithms.search;

import algorithms.sort.QuickSort;
import edu.princeton.cs.algs4.StdRandom;

// to find the k-th largest element in the array [n log n]
public class QuickSelect {
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
	
	public static Comparable select(Comparable[] a, int k) {
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while(hi > lo) {
			int j = partition(a, lo, hi);
			if(j > k) hi = j - 1;
			else if (j < k) lo = j + 1;
			else return a[k];
		}
		return a[k];
		
	}
	
	public static void main(String[] args) {
		Comparable[] a = {1,4,2,8,3,5,0,9,6,7};
		System.out.println(QuickSelect.select(a, 3));
	 	//System.out.println(a);
	} 
}
