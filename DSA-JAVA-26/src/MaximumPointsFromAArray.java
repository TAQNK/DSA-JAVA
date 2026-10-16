// given an array have to find the maximum sum/points from cards
// conditions : can pick only k number of cards and only pick from front or last (consecutive)
// [6,2,3,4,5,7,2,1,7,1] ,k = 4
// 6,2,3,4 
// 6,2,3              1
// 6,2              7,1
// 6              1,7,1
//              2,1,7,1
// find max from this given sample space
// approach :
// simple starting form front add k elements
// then start to remove elements from front (shrink)
// and expand (add) from last
// until from front it is 0 elementsq
public class MaximumPointsFromAArray {
	public static int maxPoints(int[] a, int k) {
		int lSum = 0, rSum = 0, maxSum = 0;
		for (int i = 0; i < k; i++) {
			lSum += a[i];
		}
		maxSum = lSum;
		int j = a.length - 1;
		for(int i = k -1 ; i >= 0 ; i--) {
			lSum -= a[i];
			rSum += a[j];
			j--;
			maxSum = Math.max(maxSum, lSum+rSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[]a = {6,2,3,4,5,7,2,1,7,1};
		System.out.println(maxPoints(a , 4));

	}

}
