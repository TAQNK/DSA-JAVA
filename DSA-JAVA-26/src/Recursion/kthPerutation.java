package Recursion;

import java.util.ArrayList;

/*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 


 */
/*input = [1,2,3] , k =3 
Approach : so for first index what is your options  ?
							   k ranges
			1 - 2permuations		0 - 1
			2 - 2 prem			2 -3
			3 - 2 prem		 	4 -5
		 	for first index
		 	after picking either one you will look for 2nd index
		 	1 (picked), [2 - 1prem , 3 - 1prem]
		 	2 (picked) , [1, -1prem , 3 - prem]
		 	3(pciked) , [1 - 1prem , 2 - 1prem]
		 	
		 	so my answer 3rd permutation in 2nd block
		 	how to find the second block k (3) / fact(n-1) 
		 	3/2 - > 1 so first index value [1,2,3]1st index -> 2
		 	[2 , (k(1) = 3/2 , fact(1) = fact(2) / (size(lst)=2)]
			*/
public class kthPerutation {
	public static String getPermutation(int n, int k) {
        String ans = "";
        int fact = 1;
        ArrayList lst = new ArrayList<>();
        for(int i = 1 ; i < n ; i++){
            lst.add(i);
            fact *= i;
        }
        k = k -1 ; 
        lst.add(n);
        while(true){
            ans += lst.get(k / fact);
            lst.remove(k/fact);
            if(lst.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / lst.size();
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
