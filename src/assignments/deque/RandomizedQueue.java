//package assignments.deque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item arr[];
	private int n;
	
    @Override
	public String toString() {
		return "RandomizedQueue [" + (arr != null ? "arr=" + Arrays.toString(arr) + ", " : "") + "n=" + n + "]";
	}

	// construct an empty randomized queue
    public RandomizedQueue() {
    	arr = (Item[]) new Object[1];
    	n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
    	return n;
    }

    // add the item
    public void enqueue(Item item) {
    	if(item == null) throw new IllegalArgumentException() ;
    	if(arr.length == n) resize(2*arr.length);
    	if(n == 0) arr[n++] = item;
    	else {
    		int randomIndex = StdRandom.uniform(n);
    		Item oldItem = arr[randomIndex];
    		arr[randomIndex] = item;
    		arr[n++] = oldItem;
    	}
    }
    
    private void resize(int newLength) {
    	
		Item newArr[] = (Item[]) new Object[newLength];
    	for(int i = 0; i < n; i++) {
    		newArr[i] = arr[i];
    	}
    	arr = newArr;
    }

    // remove and return a random item
    public Item dequeue() {
    	if(isEmpty()) throw new NoSuchElementException();
    	if(arr.length/4 == n) resize(arr.length/2);
    	int randomIndex = StdRandom.uniform(n);
    	Item item = arr[randomIndex];
    	arr[randomIndex] = arr[--n];
    	arr[n] = null; // to prevent loitering
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if(isEmpty()) throw new NoSuchElementException();
    	return (arr[StdRandom.uniform(n)]);
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i;
        private int[] randomIndices;
        public ArrayIterator() {
            i = 0;
            randomIndices = new int[n];
            for (int j = 0; j < n; j++) {
                randomIndices[j] = j;
            }
            StdRandom.shuffle(randomIndices);
        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[randomIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    // unit testing (required)
    public static void main(String[] args) {
    	RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
    	rq.enqueue(1);
    	rq.enqueue(2);
    	System.out.println(rq.toString());
    	rq.enqueue(3);
    	rq.enqueue(4);
    	rq.enqueue(5);
    	System.out.println(rq.toString());
    	System.out.println(rq.dequeue());
    	System.out.println("Size : " + rq.size());
    	System.out.println(rq.dequeue());
    	System.out.println(rq.dequeue());
    	System.out.println(rq.dequeue());
    	System.out.println(rq.sample());
    	System.out.println(rq.toString());
    }


}
