//problem states that  for the given string find the max len substring that is allowed to have 
// k swaps and make it a repeating char string 
// in : AABABBA , k = 2 output : 5
// approach 1 : brute force[O(n*n)*26]
//              finding the all possoiible substring and making sure that the number of changes <= k
//				maintains a hash[]
// Approach 2 : optimize[using 2 pointer adn sliding window] - O(2n) *26
// 				in this apprach we also have to contole the changes <= k  and by taking two pointer we are
//				creating new substrings  and moving l when the changes > k
//	Approach 3 : more optimize (O(n)) 
//				in prev approach we were making changes to maxFreq but it doesnt  participate when changes >k 
//				in providing the new best answer so we can avoid that and also the movement of l
//				when changes > k is not helping so only move by one .
public class LongestRepeatingReplacement {
	public static int Bruteforce(String s, int k) {
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			int maxFreq = 0;
			int hash[] = new int[26];
			for (int j = i; j < s.length(); j++) {
				hash[s.charAt(j) - 'A']++;
				maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
				int changes = (j - i + 1) - maxFreq;

				if (changes <= k) {
					maxLen = Math.max(maxLen, j - i + 1);
				} else {
					break;
				}
			}
		}
		return maxLen;
	}

	public static int Optimize(String s, int k) {
		int l = 0, r = 0, maxLen = 0, maxFreq = 0;
		int[] hash = new int[26];
		while (r < s.length()) {
			hash[s.charAt(r) - 'A']++;
			maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
//			r-l +1 = length of substring
			while ((r - l + 1) - maxFreq > k) {
				hash[s.charAt(l) - 'A']--;
				maxFreq = 0;
				for (int i = 0; i < 26; i++) {
					maxFreq = Math.max(maxFreq, hash[i]);
				}
				l++;
			}
			if ((r - l + 1) - maxFreq <= k) {
				maxLen = Math.max(maxLen, r - l + 1);
			}
			r++;
		}
		return maxLen;
	}

	public static int MoreOptimize(String s, int k) {
		int l = 0, r = 0, maxLen = 0, maxFreq = 0;
		int[] hash = new int[26];
		while (r < s.length()) {
			hash[s.charAt(r) - 'A']++;
			maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
//			r-l +1 = length of substring
			if ((r - l + 1) - maxFreq > k) {
				hash[s.charAt(l) - 'A']--;
				maxFreq = 0;
				l++;
			}
			if ((r - l + 1) - maxFreq <= k) {
				maxLen = Math.max(maxLen, r - l + 1);
			}
			r++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "AABABBA";
		System.out.println(MoreOptimize(s, 2));

	}

}
