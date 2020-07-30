package data_structures;

public class TestBST {

	public static void main(String[] args) {

		BSTree<Integer> tree = new BSTree<Integer>();
		
		tree.add(4);
		tree.add(2);
		tree.add(3);
		tree.add(1);
		System.out.println("PreOder : ");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("PostOder : ");
		tree.postOrder(tree.root);
		System.out.println("\nLevelOder : ");
		tree.levelOrder();
		System.out.println();
		if(tree.find(5)) System.out.println("5 in tree");
		if(tree.find(1)) System.out.println("1 in tree");

		tree.delete(tree.root, 4);
		System.out.println("\nLevelOder : ");
		tree.levelOrder();
		
	}

}
