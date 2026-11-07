package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MmClouring {

	static boolean goodcolor(List<Integer> adj[], int[] col) {
		for (int i = 0; i < col.length; i++) {
			for (int it : adj[i]) {
				if (i != it && col[i] == col[it])
					return false;
			}
		}
		return true;
	}

	static boolean genratecolor(int i, int[] col, int m, List<Integer> adj[]) {
		if (i >= col.length) {
			if (goodcolor(adj, col))
				return true;
			return false;
		}

		for (int j = 0; j < m; j++) {
			col[i] = j;
			if (genratecolor(i + 1, col, m, adj))
				return true;
			col[i] = -1;
		}
		return false;
	}

	static boolean graphColoring(int v, int[][] edges, int m) {
		List<Integer>[] adj = new ArrayList[v];

		// Build adjacency list from edges
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int[] it : edges) {
			adj[it[0]].add(it[1]);
			adj[it[1]].add(it[0]);
		}

		int[] color = new int[v];
		Arrays.fill(color, -1);

		return genratecolor(0, color, m, adj);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
