//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
//Example 2:
//
//Input: strs = [""]
//
//Output: [[""]]
//
//Example 3:
//
//Input: strs = ["a"]
//
//Output: [["a"]]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class GroupAnagram49 {
	// this approach works lets learn a new one where i can have freq signature for string and string[] pairs
	// those pair stored in hashmap
	    public static List<List<String>> groupAnagrams(String[] strs) {
		        List<List<String>> result = new ArrayList<>();
	            boolean visited[]= new boolean[strs.length];
		        for(int i = 0 ; i < strs.length ; i++) {
		        		ArrayList<String>res = new ArrayList<>();
		        		
	                    // if(strs[i].equals("\u0000"))continue;
	                    if(visited[i])continue;
	                    res.add(strs[i]);
	                        for(int j = i + 1; j < strs.length ; j++) {
		        		    	if(  strs[i].length() == strs[j].length() && isAnagram(strs[i] , strs[j])){
		        			    	res.add(strs[j]);
	                                visited[j] = true;
		        			    	// strs[j] ="\u0000";
		        			    }
		        		    }
	                 
		        		result.add(res);
		        		
		        }
		        return result;
		    }
		private static boolean isAnagram(String string, String string2) {
			int [] occ = new int [26];
			for(int i =0 ; i < string.length() ; i++) {
				// if(string.charAt(i) == '\u0000')continue;
				occ[string.charAt(i) - 'a']++;
			}
			for(int i =0 ; i < string.length() ; i++) {
				// if(string2.charAt(i) == '\u0000')continue;
				occ[string2.charAt(i) - 'a']--;
			}
			for(int i : occ) {
				if(i != 0 )return false;
			}
			return true;
		}
	
		
		public static List<List<String>> groupAnagrams1(String[] strs){
			HashMap<StringBuilder, ArrayList<String>> anagrams = new HashMap<>();
			for(int i = 0 ; i < strs.length ; i++) {
				StringBuilder sb = new StringBuilder();
				char ch[] = strs[i].toCharArray();
				char[] freqCount = new char[26];
				String res = "";
				for(int j = 0 ; j < strs[i].length() ; j++) {
					int count =  1;
					if(res.contains(ch[j]+""))continue;
					for(int k = j + 1; k < strs[i].length() ; k++) {
						if(strs[i].charAt(j) == strs[i].charAt(k)) {
							count++;
							res += ch[k]+"";
						}
					}
					// count is here 
					// now append that count to the string freq counter
					
					// just add that count to char location as alpahbetic order
					freqCount[strs[i].charAt(j)-'a'] = (char)(count + '0');
				}
				// till now a string in collection will have one freq string created for them
				// now i have to check for tha hashmap having that key 
				// if yes :
				// i will add that string to it value collectioon 
				//if no :
				// i will create one new key value pair of that  string and freq count string 
				// at last i will have this hash map which is pre fetch the i can return the list of all values
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub



}

}
