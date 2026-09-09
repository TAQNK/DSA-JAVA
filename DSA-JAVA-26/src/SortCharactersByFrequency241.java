//Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
//
//Return the sorted string. If there are multiple answers, return any of them.
//
// 
//
//Example 1:
//
//Input: s = "tree"
//Output: "eert"
//Explanation: 'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//Example 2:
//
//Input: s = "cccaaa"
//Output: "aaaccc"
//Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
//Note that "cacaca" is incorrect, as the same characters must be together.
//Example 3:
//
//Input: s = "Aabb"
//Output: "bbAa"
//Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
import java.util.HashMap;
import java.util.Map;
public class SortCharactersByFrequency241 {
	public static String frequencySort1(String s) {
		

		    HashMap<Character, Integer> map = new HashMap<>();

		    // 1. Create character -> frequency map
		    for (int i = 0; i < s.length(); i++) {

		        if (map.containsKey(s.charAt(i)))
		            continue;

		        int count = 1;

		        for (int j = i + 1; j < s.length(); j++) {

		            if (s.charAt(i) == s.charAt(j))
		                count++;
		        }

		        map.put(s.charAt(i), count);
		    }

		    String res = "";

		    // 2. Keep finding the character with maximum frequency
		    while (!map.isEmpty()) {

		        Map.Entry<Character, Integer> max = null;

		        for (Map.Entry<Character, Integer> e : map.entrySet()) {

		            // Ignore characters whose frequency has become 0
		            if (e.getValue() == 0)
		                continue;

		            if (max == null || e.getValue() > max.getValue()) {
		                max = e;
		            }
		        }

		        // 3. Add the maximum-frequency character
		        for (int i = 0; i < max.getValue(); i++) {
		            res += max.getKey();
		        }

		        // 4. Remove it so it isn't selected again
		        map.remove(max.getKey());
		    }

		    return res;
		
		
		
	}
	 public static  String frequencySort(String s) {
	        int [] occ = new int[256];
	        String res= "";
	        char[] ch = s.toCharArray();
	        for(char c : ch){
	            occ[c]++;
	        }
	        while(res.length() != s.length()){
	            int index = maxCountChar(occ);

	            for(int i = 0 ; i < occ[index] ; i++){
	                res += (char)occ[index];
	                occ[index]--;
	            }
	        }
	        return res;
	    }
	    public static int maxCountChar(int[] a){
	        int max = Integer.MIN_VALUE;
	        for(int i : a){
	            if(i > max)max = i;
	        }
	        return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frequencySort1("Aabb"));


}

}
