package assignments.percolation;
//package algorithms.union_find;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] grid;
	private int numberOfOpenSites;
	private final int gridSquare;
	private final int gridSize;
    private WeightedQuickUnionUF qf;
    private WeightedQuickUnionUF fullGrid;
    private final int virtualTop;
    private final int virtualBottom;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	if (n <= 0) throw new IllegalArgumentException("N must be > 0");
    	gridSize = n;
    	gridSquare = n*n;
    	grid = new boolean[gridSize][gridSize];
    	numberOfOpenSites = 0;
    	qf = new WeightedQuickUnionUF(gridSquare + 2);
    	fullGrid = new WeightedQuickUnionUF(gridSquare + 1);
    	virtualTop = gridSquare;
    	virtualBottom = gridSquare+1;
    	
    	for(int i = 0;i<n;i++) {
    		for(int j = 0;j<n;j++) {
    			grid[i][j] = false;
    		}
    	}
    	
    }
    
    // validate that p is a valid index
    private void validate(int p) {
        int n = gridSize;
        //p = p-1;
        if (p < 0 || p > n) {
            throw new IllegalArgumentException("index " + p + " is not between 1 and " + (n));  
        }
    }
    
    private boolean ifGridExists(int pos) {
    	int n = gridSquare;
        if(pos>=0 && pos<n) return true;
        else return false;
    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	
    	validate(row);
    	validate(col);
    	
    	int shiftRow = row - 1;
    	int shiftCol = col - 1;
    	
    	int shiftIndex = (shiftRow * gridSize) + shiftCol;
    	
    	if(isOpen(row, col)) return;
    	
    	numberOfOpenSites++;
    	
    	//mark as visited
    	grid[shiftRow][shiftCol] = true;
    	
    	//check if its at the top
    	if(shiftRow==0) {
    		qf.union(virtualTop, shiftIndex);
    		fullGrid.union(virtualTop, shiftIndex);
    	}
    	
    	//check if its at the bottom
    	if(shiftRow==gridSize-1) {
    		qf.union(virtualBottom, shiftIndex);
    	}
    	
    	//check and open left
    	if(ifGridExists(shiftIndex-1) && isOpen(row, col - 1)) {
    		qf.union(shiftIndex, shiftIndex-1);
    		fullGrid.union(shiftIndex, shiftIndex-1);
    		
    	}
    	
    	//check and open right
    	if(ifGridExists(shiftIndex+1) && isOpen(row, col + 1)) {
    		qf.union(shiftIndex, shiftIndex+1);
    		fullGrid.union(shiftIndex, shiftIndex+1);
    	}
    	//check and open up
    	if(ifGridExists(shiftIndex-gridSize) && isOpen(row - 1, col)) {
    		qf.union(shiftIndex, shiftIndex-gridSize);
    		fullGrid.union(shiftIndex, shiftIndex-gridSize);
    	}
    	//check and open down
    	if(ifGridExists(shiftIndex+gridSize) && isOpen(row + 1, col)) {
    		qf.union(shiftIndex, shiftIndex+gridSize);
    		fullGrid.union(shiftIndex, shiftIndex+gridSize);
    	}
    	
    	
    	
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	int n = gridSize;
    	row--;
    	col--;
    	boolean ans = false;
    	if(row>=0 && col>=0 && row<n && col<n) {
    		ans =  grid[row][col];
    	}
    	
    	return ans;
    	
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	validate(row);
    	validate(col);
    	return qf.find(virtualTop) == qf.find(((row - 1) * gridSize) + (col - 1));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
    	return qf.find(virtualTop) == qf.find(virtualBottom);
    }
    
    
 

    // test client (optional)
    public static void main(String[] args) {
//    	 int size = 3;
//
//         Percolation percolation = new Percolation(size);
//         
//         percolation.open(1, 1);
//         System.out.println(percolation.isOpen(1, 1));
//         percolation.open(1, 2);
//         percolation.open(2, 2);
//         percolation.open(2, 3);
//         percolation.open(3, 3);
//         if (percolation.percolates()) {
//             StdOut.printf("%nThe System percolates %n");
//         }
//         else {
//        	 StdOut.print("Does not percolate %n");
//         }
         
    }
}

