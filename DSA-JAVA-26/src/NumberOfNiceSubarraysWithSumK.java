import java.util.Map;

public class NumberOfNiceSubarraysWithSumK {

	public static int Bruteforce(int[]a , int k) {
		int count = 0;
		for(int i = 0 ; i <a.length ; i++) {
			int sum = 0;
			for(int j = i ; j < a.length ; j++) {
				if(a[j]%2 != 0)sum += a[j];
				if(sum == k)count++;
			}
			
		}
		return count;
	}
	public static int Optimize(int [] a , int k) {
		// using 2 pointers
		int left=  0 , right = 0, sum = 0 , count = 0;
		while(right < a.length ) {
			if(a[right] %2 != 0 )sum += a[right];
			while(sum > k) {
				if(a[left] % 2 != 0) {
					sum -= a[left];
				}
				left ++;
			}
			if(sum == k) {
				count ++;
			}
			right++;
		}
		return count;
	}
	public static int moreOptimize(int [] a , int k) {
		// using 2 pointers
		int left=  0 , right = 0, sum = 0 , count = 0;
		while(right < a.length ) {
			if(a[right] %2 != 0 )sum += a[right];
			if(sum > k) {
				if(a[left] % 2 != 0) {
					sum -= a[left];
				}
				left ++;
			}
			if(sum == k) {
				count ++;
			}
			right++;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int a[]= {1,1,2,1,1};
		System.err.println(moreOptimize(a , 3));

	}

}
