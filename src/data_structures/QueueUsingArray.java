package data_structures;

import java.util.Arrays;

public class QueueUsingArray {

	private String s[];
	private int first, last;
	private int n;
	
	public QueueUsingArray(int capacity) {
		s = new String[capacity];
		n = capacity;
		first = 0;
		last = -1;
	}
	
	public boolean isEmpty() {
		return first > last;
	}
	
	public void enqueue(String item) {
		if(last < n - 1 ) {
			s[++last] = item;
		}
		else {
			last = (last + 1) % n ;
			if(last < first) {
				s[last] = item;
			}
			else {
				throw new ArrayIndexOutOfBoundsException("Queue is FULL");
			}
		}
	}
	
	public String dequeue() {
		if(first>n -1) {
			first = first % n ;
		}
		String item = s[first];
		s[first++] = null;
		if(item == null) throw new ArrayIndexOutOfBoundsException("Removing from empty queue");
		return item;
	}

	@Override
	public String toString() {
		return "QueueUsingArray [s=" + Arrays.toString(s) + ", first=" + first + ", last=" + last + ", n=" + n + "]";
	}
	
	
}
