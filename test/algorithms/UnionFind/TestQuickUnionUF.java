package algorithms.UnionFind;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import algorithms.union_find.WQUPCUF;

public class TestQuickUnionUF {

	public static void main(String[] args) {
		WQUPCUF qu = new WQUPCUF(10);
		
		qu.union(1, 2);
		qu.printArray();
		qu.union(2, 3);
		qu.printArray();
		qu.union(3, 4);
		qu.printArray();
		System.out.println(qu.connected(1, 4));

	}

}
