
// problem  : Given an array having indexes as trees and values as types 
// and 2 baskets are given 
// now you have to pick max number of fruits given that the
// baskets are allowed to have only one type of fruit and the picking should be consecutive
//	input : [3,3,3,1,2,1,1,2,3,3,4] output : 5
// Approach 1 : BruteForce [finding all the sub arrays and storing the picks in set 
//				and if my set size gets bigger than 2 you stop adding ] - O(n*n)
// Approach 2 : Optimize [using two pointer and sliding window , just make sure that 
//				while adding elements if size of map(storing the type and freq) gets greater than 2 just remove the 
//				elements count until element count = 0 and move l simultaneously ] - O(2n)
// Approach 3 : More optimization [having to move left by one only and making sure when the siz of map is < 2 just 
//   			find new len and update if possible] - O(n)
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxNumberOfFruitsIn2Baskets {
	public static int BruteForce(int[] arr, int k) {
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < arr.length; j++) {
				set.add(arr[j]);
				if (set.size() <= k) {
					int len = j - i + 1;
					maxLen = Math.max(maxLen, len);
				} else {
					break;
				}
			}
		}
		return maxLen;
	}

	public static int Optimize(int[] arr , int k) {
		int left = 0, right = 0, maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < arr.length) {
			if (map.containsKey(arr[right]))
				map.put(arr[right], map.get(arr[right]) + 1);
			else
				map.put(arr[right], 1);
			
			while(map.size() > k) {
				map.put(arr[left],map.get(arr[left]) - 1);
				if(map.get(arr[left]) == 0) 
					map.remove(arr[left]);
				
				left++;
			}
			
			if(map.size() <= k) {
				int len = right - left + 1;
				maxLen = Math.max(maxLen, len);
			}
			right++;
		}
		return maxLen;
	}
	public static int MoreOptimize(int[] arr , int k) {
		int left = 0, right = 0, maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < arr.length) {
			if (map.containsKey(arr[right]))
				map.put(arr[right], map.get(arr[right]) + 1);
			else
				map.put(arr[right], 1);
			
			if(map.size() > k) {
				map.put(arr[left],map.get(arr[left]) - 1);
				if(map.get(arr[left]) == 0) 
					map.remove(arr[left]);
				
				left++;
			}
			
			if(map.size() <= k) {
				int len = right - left + 1;
				maxLen = Math.max(maxLen, len);
			}
			right++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		System.out.println(MoreOptimize(arr, 2));

	}

}
