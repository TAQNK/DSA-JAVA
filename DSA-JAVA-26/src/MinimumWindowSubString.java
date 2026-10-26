//Problem : Finding the min substing having all chars of string t in it 
//Solution 1 : Bruteforce(o(n*n)) - find all substrings 
//				we have to add all the char of t i a hash array 
// 				then move in the string s and check if that char is present in hash array 
//				and the hash count > 0 just add it to count++ and hash count for that index -1
//				and  if your count  == t.length() the condt is satisfied and minLen to caluate and s_index also get intialsed
//Approach 2 : Using 2POinter and slsiding window( O(2n)+O(M))
//				imilar to pervious apprach of creating the hash array and storing the char of t 
//				but when our cond is statified for once you try to shrink the subARray by moving l 
//				and also incrementing the hash value and once your count is still valid find the new min Len
import java.util.Arrays;

public class MinimumWindowSubString {
	public static String bruteForce(String s , String t) {
		int minLen = Integer.MAX_VALUE , s_index = -1;
		for(int i = 0 ; i < s.length() ; i++) {
			int[] hash = new int[256];
			Arrays.fill(hash, 0);
			for(int j = 0 ; j < t.length() ; j++) {
				hash[t.charAt(j)]++;
			}
			int count = 0;
			for(int j = i ; j < s.length() ; j++) {
				if(hash[s.charAt(j)] > 0) {
					count++;
				}
				hash[s.charAt(j)]--;
				if(count == t.length()) {
					minLen = Math.min(minLen , j-i +1);
					s_index = i;
//					min that why break
					break;
				}
			}
		}
		return s.substring(s_index , s_index + minLen  );
	}
	
	public static String Optimize(String s , String t) {
		int left = 0 , right = 0 , minLen = Integer.MAX_VALUE , count= 0 ,S_Index  = -1 ;
		int hash[] = new int[256];
		Arrays.fill(hash, 0);
		for(int i = 0 ; i < t.length() ; i++)hash[t.charAt(i)]++;
		while(right < s.length()) {
			if(hash[s.charAt(right)] > 0) {
				count++;
			}
			hash[s.charAt(right)]--;
			while(count == t.length()) {
				minLen = Math.min(minLen, right-left+1);
				S_Index = left;
				hash[s.charAt(left)]++;
				if(hash[s.charAt(left)] > 0)count --;
				left++;
			}
			right++;
		}
		return s.substring(S_Index,S_Index + minLen);
	}
	
	public static void main(String[] args) {
		String s = "ddaaabbca";
		System.out.println(Optimize(s , "abc"));
	}

}
