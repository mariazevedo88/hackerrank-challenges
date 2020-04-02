package io.github.mariazevedo88.hc.prepkit.stacks;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You are given a square grid with some cells open (.) and some blocked (X). Your playing piece can move along any 
 * row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and an end position, 
 * determine the number of moves it will take to get to the end position.
 * 
 * For example, you are given a grid with sides n=3 described as follows:
 * 
 * ...
 * .X.
 * ...
 * 
 * Your starting position (startX, startY) = (0,0) so you start in the top left corner. The ending position is 
 * (goalX, goalY) = (1,2). The path is (0,0) -> (0,2) -> (1,2). It takes 2 moves to get to the goal.
 * 
 * Function Description
 * 
 * Complete the minimumMoves function in the editor. It must print an integer denoting the minimum moves required to 
 * get from the starting position to the goal.
 * 
 * minimumMoves has the following parameter(s):
 * 
 * - grid: an array of strings representing the rows of the grid
 * - startX: an integer
 * - startY: an integer
 * - goalX: an integer
 * - goalY: an integer
 * 
 * Input Format
 * 
 * The first line contains an integer n, the size of the array grid.
 * Each of the next n lines contains a string of length n.
 * The last line contains four space-separated integers, startX, startY, goalX, goalY 
 * 
 * Constraints
 * 
 * 1 <= n <= 100
 * 0 <= startX, startY, goalX, goalY < n
 * 
 * Output Format
 * 
 * Print an integer denoting the minimum number of steps required to move the castle to the goal position.
 * 
 * Sample Input
 * 
 * 3
 * .X.
 * .X.
 * ...
 * 0 0 0 2
 * 
 * Sample Output
 * 
 * 3
 * 
 * Explanation
 * 
 * Here is a path that one could follow in order to reach the destination in 3 steps:
 * (0,0) -> (2,0) -> (2,2) -> (0,2).
 * 
 * @author Mariana Azevedo
 * @since 02/04/2020
 */
public class CastleGrid {
	
	private static final Logger logger = LoggerFactory.getLogger(CastleGrid.class);
	
	public static void main(String[] args) {
		String[] grid1 = {".X.", ".X.", "..."};
		logger.info(String.valueOf(minimumMoves(grid1, 0, 0, 0, 2))); //3
		
		String[] grid2 = {"...", ".X.", ".X."};
		logger.info(String.valueOf(minimumMoves(grid2, 2, 0, 0, 2))); //2
		
		String[] grid3 = {"...", ".X.", ".X."};
		logger.info(String.valueOf(minimumMoves(grid3, 2, 0, 2, 2))); //3
	}
	
	// Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

    	Queue<int[]> positions = new LinkedList<>();
        
    	int n = grid.length;
    	int steps = 0;
    	int nToSearch;
        
    	boolean[][] visited = new boolean[n][n];
    	visited[startX][startY] = true;
        
    	positions.add(new int[]{startX, startY});
        
        while (!positions.isEmpty()) {
        	
        	nToSearch = positions.size();
            
        	for (int i = 0; i < nToSearch; i++) {
        		int[] position = positions.poll();
        		int x = position[0];
        		int y = position[1];
               
        		if (x == goalX && y == goalY) {
        			return steps;
        		}
               
        		// traverse up direction
        		verifyUp(grid, positions, visited, x, y);
        		// down
        		verifyDown(grid, positions, n, visited, x, y);
        		// left
        		verifyLeft(grid, positions, visited, x, y);               
        		// right
        		verifyRight(grid, positions, n, visited, x, y);                 
            }
            
        	steps++;
        }
        
        return -1;
    }

    /**
     * Method that verify if is save to move right into the grid
     * 
     * @author Mariana Azevedo
     * @since 02/04/2020
     * 
     * @param grid
     * @param positions
     * @param n
     * @param visited
     * @param x
     * @param y
     */
	private static void verifyRight(String[] grid, Queue<int[]> positions, int n, boolean[][] visited, int x, int y) {
		for (int j = x+1; j < n && grid[j].charAt(y) != 'X'; j++) {
			if (!visited[j][y]) {
				positions.add(new int[]{j,y});
			   	visited[j][y] = true;
			}
		}
	}

	/**
	 * Method that verify if is save to move left into the grid
     * 
     * @author Mariana Azevedo
     * @since 02/04/2020
     * 
	 * @param grid
	 * @param positions
	 * @param visited
	 * @param x
	 * @param y
	 */
	private static void verifyLeft(String[] grid, Queue<int[]> positions, boolean[][] visited, int x, int y) {
		for (int j = x-1; j >= 0 && grid[j].charAt(y) != 'X'; j--) {
			if (!visited[j][y]) {
				positions.add(new int[]{j,y});
			   	visited[j][y] = true;
			}    
		}
	}

	/**
	 * Method that verify if is save to move down into the grid
     * 
     * @author Mariana Azevedo
     * @since 02/04/2020
     * 
	 * @param grid
	 * @param positions
	 * @param n
	 * @param visited
	 * @param x
	 * @param y
	 */
	private static void verifyDown(String[] grid, Queue<int[]> positions, int n, boolean[][] visited, int x, int y) {
		for (int j = y+1; j < n && grid[x].charAt(j) != 'X'; j++) {
			if (!visited[x][j]) {
				positions.add(new int[]{x,j});
			   	visited[x][j] = true;
			} 
		}
	}

	/**
	 * Method that verify if is save to move up into the grid
     * 
     * @author Mariana Azevedo
     * @since 02/04/2020
     * 
	 * @param grid
	 * @param positions
	 * @param visited
	 * @param x
	 * @param y
	 */
	private static void verifyUp(String[] grid, Queue<int[]> positions, boolean[][] visited, int x, int y) {
		for (int j = y-1; j >= 0 && grid[x].charAt(j) != 'X'; j--) {
			if (!visited[x][j]) {
				positions.add(new int[]{x,j});
				visited[x][j] = true;
			} 
		}
	}

}
