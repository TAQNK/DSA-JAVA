// problem states that find the substring which have abc characters in them
// Approach 1 : BruteFoce[O(n*n)]
//				in this we have look into finding the all substring possible and 
//				that will statify the condition 
//				using a hashArray that can store the character appeared or not
//	Approach 2 : optimize(slight change in time complexity)
//				we have to find the min substring that satisfy the condition 
//				and then all next element already has the condition validated
//	Approach 3 : more optimize[O(n)]
//				 in this one we have to take the elements as the point where the substring ends
//				 using a lastIndex[] which stores where the chars appreared last and can find the count
//				 by adding 1 + min(all the index of all elements)

import java.util.Arrays;

public class MaximumNumberOfSubstringWith3Characters_abc {
	public static int BruteForce(String s) {
		int count = 0;
		for(int i = 0 ; i< s.length() ; i++) {
			int[] hash = new int[3];
			for(int j = i ; j < s.length() ; j++) {
				hash[s.charAt(j) - 'a'] = 1;
				if(hash[0] + hash[1] + hash[2] == 3) {
					count ++;
				}
			}
		}
		return  count;
	}
	public static int Optimize(String s) {
		int count = 0;
		for(int i = 0 ; i< s.length() ; i++) {
			int[] hash = new int[3];
			for(int j = i ; j < s.length() ; j++) {
				hash[s.charAt(j) - 'a'] = 1;
				if(hash[0] + hash[1] + hash[2] == 3) {
					count += s.length() - j ;
					break;
				}
			}
		}
		return  count;
	}
	public static int MoreOptimize(String s) {
		int count = 0;
		int[] hash = new int[3];
		Arrays.fill(hash, -1);
		for(int i = 0 ; i < s.length() ; i++) {
			hash[s.charAt(i) - 'a'] = i;
			count += 1 + Math.min(hash[2], Math.min(hash[1], hash[0]));
		}
		return count;
	}
	public static void main(String[] args) {
		String s = "bbacba";
		System.out.println(MoreOptimize(s));

	}

}
