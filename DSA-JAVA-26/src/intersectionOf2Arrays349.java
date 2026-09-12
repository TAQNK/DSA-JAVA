import java.util.ArrayList;
import java.util.List;
//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
//
//		 
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
public class intersectionOf2Arrays349 {
	 public int[] intersection(int[] nums1, int[] nums2) {
	        List<Integer> l = new ArrayList<>();

	        for(int i = 0 ; i < nums1.length ; i++){

	            for(int j = 0 ; j < nums2.length ; j++){

	                if(nums1[i] == nums2[j] && !l.contains(nums2[j])){
	                    l.add(nums1[i]);
	                }
	            }
	        }
	        int temp[] =new int[l.size()];
	        for(int i = 0 ; i < l.size() ; i++){
	            temp[i] = l.get(i);
	        }
	        return temp;
	     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
