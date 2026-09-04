//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
// 
//
//Example 1:
//
//Input: s = "leetcode"
//
//Output: 0
//
//Explanation:
//
//The character 'l' at index 0 is the first character that does not occur at any other index.
//
//Example 2:
//
//Input: s = "loveleetcode"
//
//Output: 2
//
//Example 3:
//
//Input: s = "aabb"
//
//Output: -1
public class FirstUniqueChar387 {
	 public static int firstUniqChar(String s) {
         char ch[] = s.toCharArray();
        for(int i = 0 ; i < ch.length ; i++){
            int count = 1 ;
           
            if(ch[i] == '\u0000')continue;
            for(int j = i +1 ;j < ch.length ; j++){
                if(ch[i] == ch[j]){count++;ch[j]='\u0000';}
            }
            if(count == 1){
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
