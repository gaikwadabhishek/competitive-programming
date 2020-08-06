//package assignments.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;
	
	private class Node<T> {
		T item;
		Node next;
		Node prev;

	}


	// construct an empty deque
    public Deque() {
    	size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return size == 0;
    }

    // return the number of items on the deque
    public int size() {
    	return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
    	if (item == null) throw new IllegalArgumentException ("input must be not null");
    	Node oldFirst = first;
    	first = new Node();
    	first.item = item;
    	first.next = oldFirst;
    	
    	size++;
    	if(last == null) last = first;
    	else first.next.prev = first;
    }

    // add the item to the back
    public void addLast(Item item) {
    	if (item == null) throw new IllegalArgumentException ("input must be not null");
    	Node oldLast = last;
    	last = new Node();
    	last.item = item;
    	last.prev = oldLast;
    	if(first == null) first = last;
    	else last.prev.next = last;
    	size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	if (isEmpty()) throw new NoSuchElementException ("Deque underflow");
    	Item item = (Item) first.item;
    	first.item = null;
    	size--;
    	if(isEmpty()) {
    		first = null;
    		last = null;
    	}
    	else {
    		first = first.next;
    		first.prev = null;
    	}
    	return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
    	if (isEmpty()) throw new NoSuchElementException ("Deque underflow");
    	Item item = (Item) last.item;
    	size--;
    	if(isEmpty()) {
    		first = null;
    		last = null;
    	}
    	else {
    		last = last.prev;
    		last.next = null;
    	}
    	
    	return item;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException ();
        }

    }
    	
	

    // unit testing (required)
    public static void main(String[] args) {
    	Deque<Integer> dq = new Deque<>();
    	dq.addFirst(5);
    	dq.addFirst(6);
    	dq.addLast(7);
    	dq.addLast(8);
    	System.out.println(dq.removeFirst());
    	System.out.println(dq.removeLast());
    	System.out.println(dq.removeFirst());
    	System.out.println(dq.removeFirst());
    	System.out.println("Size is :" + dq.size());
    }

}