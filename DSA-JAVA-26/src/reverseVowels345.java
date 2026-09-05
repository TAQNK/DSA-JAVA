//Given a string s, reverse only all the vowels in the string and return it.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
// 
//
//Example 1:
//
//Input: s = "IceCreAm"
//
//Output: "AceCreIm"
//
//Explanation:
//
//The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
//
//Example 2:
//
//Input: s = "leetcode"
//
//Output: "leotcede"
public class reverseVowels345 {
	 public static String reverseVowels(String s) {
	        String vowels = "";
	        for(int i = 0 ; i < s.length() ; i++){
	            char c = s.charAt(i);
	            if(c == 'a' || c == 'e' || c == 'i'  || c == 'o' || c == 'u' || c == 'A' ||c == 'E' ||c == 'I' ||c == 'O' ||c == 'U' ){
	                vowels += c+"";
	            }
	        }
	        // now we have all vowels
	        int count = vowels.length() - 1;
	        char [] ch = s.toCharArray();
	        for(int i = 0 ; i < s.length() ;i++){
	            char c = ch[i];
	            if(c == 'a' || c == 'e' || c == 'i'  || c == 'o' || c == 'u' || c == 'A' ||c == 'E' ||c == 'I' ||c == 'O' ||c == 'U'  ){
	                ch[i] = vowels.charAt(count);
	                count--;
	            }
	        }
	        String res = "";
	        for(char c : ch)res += c+"";
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
