//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
//
//Each letter in pattern maps to exactly one unique word in s.
//Each unique word in s maps to exactly one letter in pattern.
//No two letters map to the same word, and no two words map to the same letter.
// 
//
//Example 1:
//
//Input: pattern = "abba", s = "dog cat cat dog"
//
//Output: true
//
//Explanation:
//
//The bijection can be established as:
//
//'a' maps to "dog".
//'b' maps to "cat".
//Example 2:
//
//Input: pattern = "abba", s = "dog cat cat fish"
//
//Output: false
//
//Example 3:
//
//Input: pattern = "aaaa", s = "dog cat cat dog"
//
//Output: false

// Logic is same as the Isomorhic using hasmap where we wap string to char and vice versa
import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
	public static boolean wordPattern(String pattern, String s) {
        HashMap<Character , String> PtoS = new HashMap<>();
        HashMap<String , Character> StoP = new HashMap<>();
        String[] strArr = s.split(" ");
        char [] ch = pattern.toCharArray();
        if(strArr.length != ch.length)return false;
        for(int i = 0 ; i < strArr.length ; i++){

            if(!PtoS.containsKey(ch[i]) && !StoP.containsKey(strArr[i])){
                PtoS.put(ch[i] , strArr[i]);
                StoP.put( strArr[i],ch[i] );
                continue;
            }
            else if(!PtoS.containsKey(ch[i]) || !StoP.containsKey(strArr[i])){
                return false;
            }
            else if(PtoS.get(ch[i]).equals( strArr[i]) && StoP.get(strArr[i]).equals(ch[i])){
                continue;
            }
            else if(!PtoS.get(ch[i]).equals(strArr[i]) || !StoP.get(ch[i]).equals(strArr[i])){
                return false;
            }
        }
        return true;
        
    }
	// more optimized using one hashmap only 
    public static boolean wordPattern1(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] str = s.split(" ");
        if (pattern.length() != str.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String st = str[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(st)) {
                    return false;
                }
            } else if (map.containsValue(st)) {
                return false;
            } else {
                map.put(c, st);
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub



}

}
