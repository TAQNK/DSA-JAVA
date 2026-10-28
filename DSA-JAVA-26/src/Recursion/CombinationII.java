package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// the probllem is same as cmbination 1 find the array or sub array that sum up to target 
//but twist it to avoid duplicate solutions and also you are allowed to pick number for only once
public class CombinationII {
	public static void recursion(int arr[] , int target , int index ,List ds ,Set ans ){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(index == arr.length)return;
        if(target >= arr[index]){
            ds.add(arr[index]);
            recursion(arr , target - arr[index] , index + 1 , ds , ans);
            ds.remove(ds.size() - 1);
        }
        recursion(arr , target , index + 1 , ds, ans);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans = new HashSet<>();
        recursion(candidates , target , 0 , new ArrayList<>() , ans);
        return new ArrayList<List<Integer>>(ans);
    }
    public static void main(String args[]) {
    List<List<Integer>> ans = combinationSum2(new int[]{1,2,1,1,3,7} , 7);
    System.out.println(ans);
    }

}
