package data_structures;

public class TestLinkedStackOfStrings {

	public static void main(String[] args) {
		
		LinkedStackofStrings stack = new LinkedStackofStrings();
		stack.push("Abhishek");
		System.out.println(stack.pop());
		stack.push("Gaikwad");
		stack.push("1");
		stack.push("2");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());

	}

}
