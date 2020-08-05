package data_structures;

public class ResizingStackOfString {

	private String s[];
	private int n = 0;

	public ResizingStackOfString() {
		s = new String[1];
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public void push(String item) {
		if(n == s.length) resize(2*s.length); //resizing
		s[n++] = item;
	}
	
	//resizing
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		for(int i = 0; i < n; i++ ) {
			copy[i] = s[i];
		}
		s = copy;
	}
	
	public String pop() {
		String item = s[--n];
		s[n] = null;
		if (n > 0 && n == s.length/4) resize(s.length / 2); // shrinking size of array if its only 25% full
		return item;
	}
	
}
