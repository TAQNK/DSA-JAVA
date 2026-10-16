//problem  : given a string find the max length of the substring inside having only non repeated chars
//approach : 
// a. Bruteforce
// 		in this approach find the substring for each of the char in string 
// 		maintain a hasharray for each char to check whether the char had already appeared or not and 
//		if appeared then break else you add and find max len 
// 		repeat

// b. Optimized (2pointer and sliding window)
//		intitalise l = 0 r = 0 
// 		maintain only one hash[256] - > intialize with -1 (representing not repeated)
// 		when adding check in hash if persent move l to hash[s.charAt(r)]+1 (only if l > that index)
// 		if not present simply add the index to hashArray  and find len and update maxLen if possible 

import java.util.Arrays;

public class MaximumLenOfNonRepeatedSubString {
	public static int MaxLenSubStringNonRepeat_UsingBruteForce(String s) {
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] hash = new int[256];
			for (int j = i; j < s.length(); j++) {
				if (hash[s.charAt(j)] == 1) {
					// repeated
					break;
				}
				// not repeated

				int len = j - i + 1;
				maxLen = Math.max(maxLen, len);
				hash[s.charAt(j)] = 1;
			}
		}
		return maxLen;
	}

	public static int MaxLenSubStringNonRepeat_UsingOptimized(String s) {
		int[] hash = new int[256];
		Arrays.fill(hash, -1);
		int l = 0, r = 0, maxLen = 0;
		while (r < s.length()) {
			if(hash[s.charAt(r)] != -1) {
				//repeated
				if(l <= hash[s.charAt(r)]) {
					// update l
					l = hash[s.charAt(r)]+1;
				}
			}
			int len = r - l +1;
			maxLen = Math.max(maxLen, len);
//			new index
			hash[s.charAt(r)] = r;
			r++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "cadbzabcd";
		System.out.println(MaxLenSubStringNonRepeat_UsingOptimized(s));
	}

}
