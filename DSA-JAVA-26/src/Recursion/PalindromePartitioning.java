package Recursion;

import java.util.ArrayList;
import java.util.List;
// make sure when partitoning that substring formed must be a palindorme and at each step you can partition at index - > s.length() -1
public class PalindromePartitioning {
	 public static List<List<String>> partition(String s) {
	        List<List<String>> ans  = new ArrayList<>();
	        recursion(s , 0, new ArrayList<>() , ans);
	        return ans;
	    }
	    public static void recursion(String s , int index , List ds , List ans){
	        if(index == s.length()){
	            ans.add(new ArrayList<>(ds));
	            return;
	        }
	        for(int i = index ; i < s.length() ; i++){
	            if(isPalindrome(s , index , i)){
	                String sub = s.substring(index , i + 1);
	                ds.add(sub);
	                recursion(s , i + 1 , ds , ans);
	                ds.remove(ds.size() - 1);
	            }
	        }
	    }
	    public static boolean isPalindrome(String sub , int i , int j){
	        while(i <= j){
	            if(sub.charAt(i) != sub.charAt(j)){
	                return false;
	            }
	            i++;
	            j--;
	        }
	        return true;    
	    }
	public static void main(String[] args) {
		

	}

}
