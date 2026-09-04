//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
// 
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//
//Output: true
//
//Example 2:
//
//Input: s = "rat", t = "car"
//
//Output: false
public class isAnagram242 {
	 public static boolean isAnagram(String s, String t) {
	        if(s.length() == 0 && t.length() == 0)return true;
	        if(s.length() != t.length())return false;
	        char c = s.charAt(0);
	        return isAnagram(s.replace(c+"" ,"") , t.replace(c+"" ,""));
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
