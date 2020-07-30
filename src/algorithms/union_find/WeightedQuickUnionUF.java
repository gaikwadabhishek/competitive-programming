package algorithms.union_find;

public class WeightedQuickUnionUF {
	private int id[];
	private int sz[];
	
	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
			sz[i] = 1;
			
		}
	}
	
	private int root(int i) {
		//check parent pointers until they reach root
		while(id[i]!=i) i = id[i];		
		return i;
	}
	
	public boolean connected(int p, int q) {
		//check if p and q have same root
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		//change root of p to root of q
		int i = root(p);
		int j = root(q);
	
		if(sz[i]<sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];
		}
		
		
	}
	public void printArray() {
		System.out.println("0123456789");
		for(int i=0;i<id.length;i++) {
			System.out.print(id[i]);
		}
		System.out.println();
	}
}
