package algorithms.UnionFind;

import algorithms.union_find.QuickFindUF;

public class TestQuickFindUF {

	public static void main(String[] args) {
		QuickFindUF qf = new QuickFindUF(10);
		qf.union(4, 3);
		qf.union(3, 8);
		qf.union(6, 5);
		qf.union(9, 4);
		qf.union(2, 1);
		System.out.println(qf.connected(0, 7));
		qf.connected(8, 9);
		qf.union(5, 0);
		qf.union(7, 2);
		System.out.println(qf.connected(3, 9));
		System.out.println("0123456789");
		qf.printArray();
	}

}
