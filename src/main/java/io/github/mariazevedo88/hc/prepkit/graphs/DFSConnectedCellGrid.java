package io.github.mariazevedo88.hc.prepkit.graphs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consider a matrix where each cell contains either a 0 or a 1 and any cell containing a 1 is 
 * called a filled cell. Two cells are said to be connected if they are adjacent to each other 
 * horizontally, vertically, or diagonally. In the diagram below, the two colored regions show 
 * cells connected to the filled cells. Black on white are not connected.
 * 
 * Cells adjacent to filled cells:
 * 
 * 000001
 * 010000
 * 000000
 * 
 * If one or more filled cells are also connected, they form a region. Note that each cell in a 
 * region is connected to at least one other cell in the region but is not necessarily directly 
 * connected to all the other cells in the region.
 * 
 * Regions: 
 * 
 * 110001
 * 011000
 * 000100
 * 
 * Given an n x m matrix, find and print the number of cells in the largest region in the matrix.
 * 
 * Function Description
 * 
 * Complete the function maxRegion in the editor below. It must return an integer value, the size 
 * of the largest region.
 * 
 * maxRegion has the following parameter(s):
 * - grid: a two dimensional array of integers
 * 
 * Input Format
 * 
 * The first line contains an integer, n, the number of rows in the matrix, grid.
 * The second line contains an integer, m, the number of columns in the matrix.
 * 
 * Each of the following n lines contains a row of m space-separated integers, grid[i][j].
 * 
 * Constraints
 * 
 * 0 < n,m < 10
 * grid[i][j] E {0,1}
 * 
 * Output Format
 * 
 * Print the number of cells in the largest region in the given matrix.
 * 
 * Sample Input
 * 
 * 4
 * 4
 * 1 1 0 0
 * 0 1 1 0
 * 0 0 1 0
 * 1 0 0 0
 * 
 * Sample Output
 * 
 * 5
 * 
 * Explanation
 * 
 * The diagram below depicts two regions of the matrix:
 * 
 * 1100
 * 0110
 * 0010
 * 1000
 * 
 * The first region has five cells and the second region has one cell. We choose the larger 
 * region.
 * 
 * @author Mariana Azevedo
 * @since 24/02/2020
 */
public class DFSConnectedCellGrid {
	
	private static final Logger logger = LoggerFactory.getLogger(DFSConnectedCellGrid.class);
	
	public static void main(String[] args) {
		
		int[][] grid1 = {{1,1,0,0},{0,1,1,0},{0,0,1,0},{1,0,0,0}};
		logger.info(String.valueOf(maxRegion(grid1)));
		
		int[][] grid2 = {{0,0,1,1},{0,0,1,0},{0,1,1,0},{0,1,0,0},{1,1,0,0}};
		logger.info(String.valueOf(maxRegion(grid2)));
		
		int[][] grid3 = {{1,0,1,1,0},{1,1,0,0,1},{0,1,1,1,0},{0,0,0,0,1},{1,1,1,0,0}};
		logger.info(String.valueOf(maxRegion(grid3)));
	}
	
	// Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {

        int maxRegion = Integer.MIN_VALUE;
        
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
        		if (grid[i][j] == 1) {
        			int regionSize = findLargestRegion(grid, i, j);
        			maxRegion = Math.max(maxRegion, regionSize);
        		}
        	}
        }
        
        return maxRegion;
    }
	
	private static int findLargestRegion(int [][] grid, int row, int col) {
        
		//region is out of bounds
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
			return 0;
		}
		
		// already seen or never part of a region
		if (grid[row][col] == 0) {
			return 0;
		}
		
		// mark as seen
		grid[row][col] = 0;
		int size = 1;
		
		// search all 8 directions recursively
		for (int i = row-1; i <= row+1; i++) {
			for (int j = col-1; j <= col+1; j++) {
				if (i == row && j == col) {
					//node already marked as seen
					continue;
		        }
		        size += findLargestRegion(grid, i, j);
		    }
		}
		
		return size;
    }

}
