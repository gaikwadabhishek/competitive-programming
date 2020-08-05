package data_structures;

public class TestQueueUsingArray {

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray(3);
		System.out.println(queue.isEmpty());
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		queue.enqueue("D");
		System.out.println(queue.dequeue());
		queue.enqueue("E");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		
	}

}
