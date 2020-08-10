package algorithms.sort;

public class Selection {

	public static void sort(Comparable[] a) {
		int length = a.length;
		for(int i = 0; i < length - 1; i++) {
			int min = i;
			for(int j = i+1; j < length; j++) if(less(a[j], a[min])) min = j;
			exchg(a, i, min);
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
		Comparable[] a = {'a','c','b'};
		Selection.sort(a);
	 	System.out.println(a);
	}
}
