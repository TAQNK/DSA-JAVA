
// problem states that you have to find the max possible substring having atmost k distinct alphabets
// Approach 1 : [BruteForce - O(n*n) + O(256)]
//				In this try to find all the possible substrings that checks for the condition
//				i.e the number of distinct in substring to be <= k 
//				Using map we can store character and frequency of character and len to check to 
// 				number of distinct.
// Approach 2: [Optimize - O(2n)+ O(256)]
//				Using two pointers and sliding window as old questions similarly we have to move our right 
//				and find new window is possible or not (<= k) and if possible find new len 
//				else move left and remove the elements from map 
// Approach 3: [More Optimize - O(n) + O (256)
//				Using  similarly approach but reduce the time complexity in removing elements from map
import java.util.Map;
import java.util.HashMap;

public class MaxLenSubStringHavingAtmostKDistinctAlphabets {
	public static int BruteForce(String s, int k) {
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.clear();
			for (int j = i; j < s.length(); j++) {
				if (map.containsKey(s.charAt(j))) {
					map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
				} else
					map.put(s.charAt(j), 1);

				if (map.size() <= k) {
					maxLen = Math.max(maxLen, j - i + 1);
				} else {
					break;
				}
			}
		}
		return maxLen;
	}

	public static int Optimize(String s , int k) {
			int left = 0  ,right = 0, maxLen = 0;
			Map<Character , Integer> map = new HashMap<>();
			
			while(right < s.length()) {
				if(map.containsKey(s.charAt(right))) {
					map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
				}else {
					map.put(s.charAt(right), 1);
				}
				while(map.size() > k) {
					map.put(s.charAt(right), map.get(s.charAt(right)) -1);
					if(map.get(s.charAt(right)) == 0) {
						map.remove(s.charAt(right));
					}
					left ++;
				}
				if(map.size() <= k) {
					maxLen = Math.max(right - left + 1, maxLen);
				}
				right++;
			}
		return maxLen;

	}
	public static int MoreOptimize(String s , int k) {
		int left = 0  ,right = 0, maxLen = 0;
		Map<Character , Integer> map = new HashMap<>();
		
		while(right < s.length()) {
			if(map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
			}else {
				map.put(s.charAt(right), 1);
			}
			if(map.size() > k) {
				map.put(s.charAt(right), map.get(s.charAt(right)) -1);
				if(map.get(s.charAt(right)) == 0) {
					map.remove(s.charAt(right));
				}
				left ++;
			}
			if(map.size() <= k) {
				maxLen = Math.max(right - left + 1, maxLen);
			}
			right++;
		}
	return maxLen;

}

	public static void main(String[] args) {
		String s = "aaabbccd";
		System.out.println(MoreOptimize(s, 2));

	}

}
