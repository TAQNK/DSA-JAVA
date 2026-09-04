//Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// 
//
//Example 1:
//
//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
//Example 2:
//
//Input: s = "Mr Ding"
//Output: "rM gniD"
// 
public class reverseWordsinaStringIII557 {
	
	    public static String reverseWords(String s) {
	       String[] sp = s.split(" ");
	       StringBuilder res = new StringBuilder();
	       for(int i = 0 ; i < sp.length ; i++){
	        StringBuilder sb = new StringBuilder(sp[i]);
	        sb.reverse();
	        res.append(sb);
	        if(i < sp.length - 1)res.append(" ");
	       }
	       return res.toString();
	    }
	
}
