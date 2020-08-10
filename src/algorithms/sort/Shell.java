package algorithms.sort;

public class Shell {

	public static void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;
		while(h < n/3) h = 3*h+1;
		
		while(h >= 1) {
			for(int i = h; i < n; i++) {
				for(int j = i; j >= h && less(a[j], a[j - h]); j -= h ) {
					exchg(a, j, j-h);
				}
			}
			
			h = h / 3;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] a = {'A','C','B'};
		Shell.sort(a);
	 	System.out.println(a);
	}

}
