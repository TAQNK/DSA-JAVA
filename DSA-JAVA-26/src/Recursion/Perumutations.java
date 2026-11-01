package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//		 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Example 2:
//
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//Example 3:
//
//Input: nums = [1]
//Output: [[1]]
//
// Approach 1 : O(n! * n) You have to mantain a hashArray / freq array where the element is not pricked or picked will be represented and 
//				at each check you will check for hash[i] == 1 i.e picked and if not then pick the element and call for recusion again and on returning remove the element
//				and on picking all the elements you add the answer in a list.

//Approach 2 : O(n!*n) because using the swap instead pf storing the freq array .but Space Complexity is saved.
public class Perumutations {
	public static void rec(int[] arr, List ds, List ans, int[] hashArr) {
		if (ds.size() == arr.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (hashArr[i] != 1) {
				ds.add(arr[i]);
				hashArr[i] = 1;
				rec(arr, ds, ans, hashArr);
				ds.remove(ds.size() - 1);
				hashArr[i] = 0;
			}
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		rec(nums, new ArrayList<>(), ans, new int[nums.length]);
		return ans;
	}

	
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void rec(int[] arr, int st, int end, List ans) {
		if (st == end) {
			List<Integer> ds = new ArrayList<>();
			for (int i : arr) {
				ds.add(i);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = st; i <= end; i++) {
			swap(arr, st, i);
			rec(arr, st + 1, end, ans);
			swap(arr, st, i);
		}
	}

	public static List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		rec(nums, 0, nums.length - 1, ans);
		return ans;
	}

	public static void main(String[] args) {
		List<List<Integer>> ans = permute2(new int[] { 1, 2, 3 });
		for (List<Integer> row : ans) {
			System.out.println(Arrays.toString(row.toArray()));
		}

	}

}
