package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueens {
	 public static boolean validQueen(int r, int c, char[][] b, int n) {

	        int dRow = r;
	        int dCol = c;

	        // Check upper-left diagonal
	        while (r >= 0 && c >= 0) {
	            if (b[r--][c--] == 'Q') return false;
	        }

	        r = dRow;
	        c = dCol;

	        // Check left side
	        while (c >= 0) {
	            if (b[r][c--] == 'Q') return false;
	        }

	        r = dRow;
	        c = dCol;

	        // Check lower-left diagonal
	        while (r < n && c >= 0) {
	            if (b[r++][c--] == 'Q') return false;
	        }

	        return true;
	    }

	    public static void nQueen(int col, char[][] board,
	                              List<List<String>> ans, int n) {

	        if (col == n) {

	            List<String> ds = new ArrayList<>();

	            for (int i = 0; i < n; i++) {
	                ds.add(new String(board[i]));
	            }

	            ans.add(ds);
	            return;
	        }

	        for (int row = 0; row < n; row++) {

	            if (validQueen(row, col, board, n)) {

	                board[row][col] = 'Q';

	                nQueen(col + 1, board, ans, n);

	                board[row][col] = '.';
	            }
	        }
	    }

	    public static List<List<String>> solveNQueens(int n) {

	        List<List<String>> ans = new ArrayList<>();

	        char[][] board = new char[n][n];

	        for (int i = 0; i < n; i++) {
	            Arrays.fill(board[i], '.');
	        }

	        nQueen(0, board, ans, n);

	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
