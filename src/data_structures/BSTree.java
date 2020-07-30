package data_structures;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree<E extends Comparable<? super E>> {

	Node<E> root;
	int size;
	
	public BSTree() {
		root = new Node<E>(null);
		size = 0;
	}
	
	public boolean add(E e) {
		if(root.getData() == null) {
			root.setData(e);
		}
		else {
			Node<E> curr = root;
			int comp = e.compareTo(curr.getData());
			while((comp<0 && curr.getLeft()!=null) || (comp>0 && curr.getRight()!=null)) {
				if(comp<0) curr = curr.getLeft();
				else curr = curr.getRight();
				comp = e.compareTo(curr.getData());
			}
			if(comp<0) curr.setLeft(new Node<E>(e));
			else if(comp>0) curr.setRight(new Node<E>(e));
			else return false;
		}
		
		return true;
		
	}
	public void preOrder(Node<E> node) {
		if(node!=null) {
			System.out.print("\t" + node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	public void postOrder(Node<E> node) {
		if(node!=null) {
			
			postOrder(node.getLeft());
			System.out.print("\t" + node.getData());
			postOrder(node.getRight());
		}
	}
	public void inOrder(Node<E> node) {
		if(node!=null) {
			
			inOrder(node.getLeft());
			System.out.print("\t" + node.getData());
			inOrder(node.getRight());
		}
	}
	
	public void levelOrder() {
		Queue <Node<E>> q = new LinkedList<Node<E>>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node<E> currNode = q.remove();
			if(currNode!=null) {
				System.out.print("\t" + currNode.getData());
			
				if(currNode.getLeft()!=null) q.add(currNode.getLeft());
				
				if(currNode.getRight()!=null) q.add(currNode.getRight());
			}
		}
		
	}
	
	public boolean find(E e) {
		
		Node<E> curr = root;
		int comp;
		
		while(curr != null) {
			comp = e.compareTo(curr.getData());
			if(comp<0) {
				curr = curr.getLeft();
			}
			else if(comp>0) {
				curr = curr.getRight();
			}
			else {
				return true;
			}
			
		}
		
		return false;
	}
	public E getMinValue(Node<E> node) {
		
		while(node.getLeft()!=null) {
			node = node.getLeft();
		}
		return node.getData();
		
	}
	
	
	public Node<E> delete(Node<E> node,E e) {
		Node<E> curr = node;
		int comp;
		if(curr!=null) {
			comp = e.compareTo(curr.getData());
			if(comp<0) {
				curr.setLeft(delete(curr.getLeft(),e));
			}
			else if(comp>0) {
				curr.setRight(delete(curr.getRight(),e));
			}
			else {
				if(curr.getLeft()==null && curr.getRight()==null) {
					System.out.println("Deleting "+ curr.getData());
					return null;
				}
				else if(curr.getLeft()!=null && curr.getRight()==null) {
					System.out.println("Deleting "+ curr.getLeft().getData());
					return curr.getLeft();
					
				}
				else if(curr.getLeft()==null && curr.getRight()!=null) {
					System.out.println("Deleting "+ curr.getRight().getData());
					curr = curr.getRight();
				}
				else {
					E min = getMinValue(node.getRight());
					curr.setData(min);
					curr.setRight(delete(curr.getRight(), min));
					System.out.println("deleting "+curr.getData());
					
				}
			}
		}
		return curr;
	}
	
	
}

class Node<E>{
	E data;
	Node<E> left;
	Node<E> right;
	
	Node(){
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	Node(E e){
		this();
		this.data = e;
	}
	
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	

	
}