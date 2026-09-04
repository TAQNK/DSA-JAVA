//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
// 
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
//Constraints:
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] consists of only lowercase English letters if it is non-empty.
public class longestCommonPrefix14 {
	public static String longestCommonPrefix(String[] strs) {
		 int i = 1;
	        if(strs.length == 1)return strs[0];
	        String sub = "";
	        while(i <= strs[0].length()){
	            sub = strs[0].substring(0,i);
	            
	            for(int j = 1 ; j < strs.length ; j++){
	                if(strs[j].length() < i || ! strs[j].substring(0,i).equals(sub)){
	                    i = i - 1;
	                    return strs[0].substring(0,i);
	                }
	                
	            }
	            i++;
	        }
	        return sub;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonPrefix(new String[]{"flower" ,"flower"}));
	}

}
