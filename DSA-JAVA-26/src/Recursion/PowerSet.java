package Recursion;

import java.util.ArrayList;
import java.util.List;

//problem is to find all the possible subsets possible in a int array


public class PowerSet {
	public static List  powerSet(int[]a){
		int n  = a.length ;
		List ans = new ArrayList<>();
		int subsets = 1 << n;
		for(int i = 0 ; i < subsets ; i++) {
			List lst = new ArrayList<>();
			for(int l = 0 ; l < n ; l++) {
				if(  (i & (1 << l)) != 0 ) {
					lst.add(a[l]);
				}
			}
			ans.add(lst);
			
		}
		return ans;}
	
	public static void main(String[] args) {
		System.out.println(powerSet(new int[] {5,2,1}));

	}

}
