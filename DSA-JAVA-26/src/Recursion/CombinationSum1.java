package Recursion;

import java.util.ArrayList;
import java.util.List;

// problme is [2,2,3,4,7] and target = 7 and you are allowed to pick a number more than once
//Solution :  USing Pick and not pick apprach at each step you can either pick or not the number and can repick the number when you choose 
public class CombinationSum1 {
	public static void Recursion(int[]arr , int target , int index , List<Integer> ds ,List<List<Integer>> ans){
		if(target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		if(index == arr.length)return;
		
		if(target >= arr[index]) {
			ds.add(arr[index]);
			Recursion(arr, target - arr[index], index, ds, ans);
			ds.remove(ds.size() - 1);
		}
		Recursion(arr, target, index+1, ds, ans);
	}
	public static void main(String[] args) {
		
		int[]arr = {2,2,3,4,7};
		List<List<Integer>> ans = new ArrayList<>();
		Recursion(arr , 7 , 0 , new ArrayList<>() , ans);
		System.out.println(ans);
	}

}
