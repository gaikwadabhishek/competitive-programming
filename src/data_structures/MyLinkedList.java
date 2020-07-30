package data_structures;

public class MyLinkedList<E>  {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		this.size = 0;
		
		head.next = tail;
		tail.prev = head;
	}
	
	public void add(E e) {
		LLNode<E> prevNode = head;
		LLNode<E> newNode = new LLNode(e);
		
		newNode.prev = tail.prev ;
		tail.prev = newNode;
		newNode.prev.next = newNode;
		newNode.next = tail;
		
		size++;
		
		
	}
	
	

}

class LLNode<E>{
	
	E data;
	LLNode<E> prev;
	LLNode<E> next;
	
	public LLNode() {
		data = null;
		prev = null;
		next = null;
	}
 
	public LLNode(E element) {
		this();
		this.data = element;
	}
	
}
