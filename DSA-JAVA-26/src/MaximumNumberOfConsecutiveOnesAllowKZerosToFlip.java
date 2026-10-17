// problem : find the maximun number of conectuive ones and allowed k zeros to be flliped
// input : [1,1,1,0,0,0,1,1,1,1,0]  , k = 2

// approach 1 : Bruteforce O(n*n)
//				Find all subarrays and make sure that number of zeros stay within k and just look for maxlen
// approach 2 : optimize O(2n)
//				taking two pointers and move r just check if zero the increment nuOfZero and if numberOfZeros get greater than 
//				k thenmove your l where number of zeros get smaller than k and then fnd the len and update maxLen
// approach 3 : more optimize O(n) 
//				taking the same case as above but we will optimize movement of left by allowing ony one move and 
//				making sure that when nuofzeros  gets < k then find len and maxLen 
public class MaximumNumberOfConsecutiveOnesAllowKZerosToFlip {
	public static int BruteForce(int[]a , int k) {
		int maxLen = 0;
		for(int i = 0 ; i < a.length ; i++) {
			int noOfZero = 0;
			for(int j = i ; j < a.length ; j++) {
				if(a[j] == 0) {
					noOfZero ++;
				}
				if(noOfZero > k) {
					break;
				}else {
					int len = j - i + 1;
					maxLen = Math.max(len, maxLen);
				}
			}
		}
		return maxLen ;
	}
	public static int optimize(int[]a,int k) {
		int left = 0 , right = 0 , maxLen = 0 ,noOfZero = 0;
		
		while(right < a.length) {
			if(a[right] == 0) {
				noOfZero ++;
			}
			while(noOfZero > k) {
				if(a[left] == 0) {
					noOfZero --;
				}
				left++;
			}
			if(noOfZero <= k) {
				int len = right - left + 1;
				maxLen = Math.max(maxLen, len);
			}
			right++;
		}
		return maxLen ;
	}
	public static int moreOptimize(int[]a,int k) {
		int left = 0 , right = 0 , maxLen = 0 ,noOfZero = 0;
		
		while(right < a.length) {
			if(a[right] == 0) {
				noOfZero ++;
			}
			if(noOfZero > k) {
				if(a[left] == 0) {
					noOfZero --;
				}
				left++;
			}
			if(noOfZero <= k) {
				int len = right - left + 1;
				maxLen = Math.max(maxLen, len);
			}
			right++;
		}
		return maxLen ;
	}
	
	
	public static void main(String[] args) {
		int []a = {1,1,1,0,0,0,1,1,1,1,0};
		System.out.println(moreOptimize(a , 2));
	}

}
