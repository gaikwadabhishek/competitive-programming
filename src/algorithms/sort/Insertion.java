package algorithms.sort;

public class Insertion {

	public static void sort(Comparable[] a) {
		int n = a.length;
		for(int i = 0; i < n; i++) {
			for(int j = i; j > 0; j--) {
				if(less(a[j], a[j-1])) {
					exchg(a, j, j - 1);
				}
				else break;
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0 ;
	}
	
	private static void exchg (Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String args[]) {
		Comparable[] a = {'A','C','B'};
		Insertion.sort(a);
	 	System.out.println(a);
	}
	
}
