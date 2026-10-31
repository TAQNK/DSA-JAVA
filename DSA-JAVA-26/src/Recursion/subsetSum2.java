package Recursion;
//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//Example 2:
//
//Input: nums = [0]
//Output: [[],[0]]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetSum2 {
	public static void rec(int []arr , int index , List ds , List ans){
        ans.add(new ArrayList<>(ds));
        for(int i =  index ; i < arr.length ; i++){
            if(index != i && arr[i - 1] == arr[i])continue;
            ds.add(arr[i]);
            rec(arr,  i + 1 ,ds ,ans );
            ds.remove(ds.size() - 1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lst = new ArrayList<>();
        rec(nums , 0 , new ArrayList<>() , lst);
        return lst;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
