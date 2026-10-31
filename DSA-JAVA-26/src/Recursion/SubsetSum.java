package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
	// recsursion is checking is the subset sum can have sum reacher target
	 public static boolean recusion(int[]a , int sum , int index , int target){
	        
	        if(index == a.length){
	            return sum == target;
	        }
	        sum+= a[index];
	        boolean ans1 = recusion(a , sum , index + 1 , target);
	        sum -= a[index];
	        boolean ans2 = recusion(a, sum , index + 1 ,target);
	        return ans1 == true || ans2 == true ? true : false;
	    }
	 // second problem finding all the subset sum and printing in descending
	 
	   public static void rec(int []a , int index  , int sum , List ans){
	        if(index == a.length){
	            ans.add(sum);
	            return;
	        }
	        rec(a , index +1  ,sum + a[index],  ans);
	        rec(a , index + 1, sum , ans);
	    }
	    public static  List<Integer> subsetSums(int[] nums) {
	        List<Integer> sum = new ArrayList<>();
	        rec(nums , 0 , 0 , sum);
	        Collections.sort(sum);
	        return sum;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
