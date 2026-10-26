import java.util.HashMap;
import java.util.Map;

public class MaxCountOfSubarraysHavingKsum {
	public static int Bruteforce(int[]a , int k) {
		int count = 0;
		for(int i = 0 ; i < a.length ; i++) {
			for(int j = i ; j < a.length ; j++) {
				int sum = 0;
				for(int l = i ;l <= j ; l++) {
					sum += a[l];
				}
				if(sum == k)count++;
			}
		}
		return count;
	}
	public static int Optimize(int[]a , int k) {
		int count = 0;
		for(int i = 0 ; i < a.length ; i++) {
			int sum = 0;
			for(int j = i ; j < a.length ; j++) {
				sum += a[j];
				if(sum == k)count++;
			}
		}
		return count;
	}
	
	public static int moreOptimize(int []a , int k) {
		// map < prefixSum , count >
		// prefix sum solution 
		// to look for prefixSum - k inside map to get the count
		int count = 0 ;
		Map<Integer , Integer> map = new HashMap<>();
		map.put(0, 1);
		int prefixSum = 0;
		for(int i = 0 ; i < a.length ; i++) {
			prefixSum += a[i];
			int remove = prefixSum - k;
			if(map.containsKey(prefixSum)) {
				map.put(prefixSum, map.get(prefixSum) + 1);
			}else {
				map.put(prefixSum, 1);
			}
			if(map.containsKey(remove)) {
				count += map.get(remove);
			}
			
		}
		return count;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,-3,1,1,1,4,2,-3};
		System.out.println(moreOptimize(a,  3));

	}

}
