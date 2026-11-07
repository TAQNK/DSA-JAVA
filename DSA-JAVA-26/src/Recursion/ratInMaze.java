package Recursion;

import java.util.ArrayList;
import java.util.List;

public class ratInMaze {
	public static void rec(int[][] maze, int row, int col, int[][]visited, List ans, String s) {
		if (row == maze.length -1  && col == maze[row].length- 1) {
			for(int[] a : visited) {
				for(int i : a) {
					System.out.print(i);
				}
				System.out.println();
			}
			System.out.println(s);
			ans.add(s);
			return;
		}
		
		// down
		if (isValid(maze, row + 1, col, visited)) {
			visited[row][col] = 1;
			rec(maze, row + 1, col, visited, ans, s+"D");
			visited[row][col] = 0;
		}
		
		// left
		if (isValid(maze, row, col - 1, visited)) {
			visited[row][col] = 1;
			rec(maze, row, col - 1, visited, ans, s+"L");
			visited[row][col] = 0;
		}
		
		// rigth
		if (isValid(maze, row, col + 1, visited)) {
			visited[row][col] = 1;
			rec(maze, row, col + 1, visited, ans, s+"R");
			visited[row][col] = 0;
		}
		
		// up
		if (isValid(maze, row - 1, col, visited)) {
			visited[row][col] = 1;
			rec(maze, row - 1, col, visited, ans, s+"U");
			visited[row][col] = 0;
			
		}
		
	}
	public static boolean isValid(int[][] m , int row , int col , int[][] visited){
	    if(row >= 0 && row < m.length && col >=0 && col < m[row].length){
	       
	        if(m[row][col] == 1 && visited[row][col] == 0)
	        		return true;
	    }
	    return false;
	}
	public static ArrayList<String> ratInMaze(int[][] maze) {
		// code here
		ArrayList<String> ans = new ArrayList<>();
		if(maze[0][0] == 0 || maze.length == 0)return new ArrayList();
		rec(maze, 0, 0, new int[maze.length][maze[0].length], ans, "");
		return ans;
	}
	public static void main(String[] args) {
		int[][] m = {{0,1,1,1} , {1,1,0,1} ,{1,1,0,0} , {0,1,1,1}};
		List<String> ans = ratInMaze(m);
		System.out.println(ans);

	}

}
