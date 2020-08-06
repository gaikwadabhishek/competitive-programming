package data_structures;

import java.util.Iterator;
import java.util.ListIterator;

public class LinkedStackOfItems<T> implements Iterable<T> {

	private Node first = null;
	
	public Iterator<T> iterator() { 
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		private Node<T> current  = first;
		public boolean hasNext() {
			return current != null;
		}
		public T next() {
			T item = (T) current.item;
			current = current.next;
			return item;
		}
		
	}
	private class Node<T> {
		T item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public T pop() {
		T item = (T) first.item;
		first = first.next;
		return item;
	}
}


