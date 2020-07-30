package data_structures;

public class TestLL {

	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		
		ll.add(1);
		ll.add(3);
		ll.add(3);
		
		System.out.println(ll.size);
		LLNode node = ll.head;
		String abcd = "1234";
		for(int i = 0 ; i < abcd.length() ; i++) {
			Integer t1 = Character.getNumericValue(abcd.charAt(i));
			System.out.println(t1);
		}
	}

}
