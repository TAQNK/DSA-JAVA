//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.
// Input - [1,2,3] output - [1,2,4]
// Input - [9] output - [1,0]

// LOGIC :
// Is to check weather the index elemet + 1 is 10 or not if not then i can plus 1 and return arr 
// but if equal to 10 then just make that index element to be 0 and repeat the iteration if whole length of arr is parsed then all elements will be 0
// then make a new array and make 0th index element to be 1 and return arr 

import java.util.Arrays;

public class addOne66 {

	public static int[] addOne(int[] digits) {
		for(int i = digits.length-1  ; i >= 0; i--) {
			if(digits[i] + 1 != 10) {
				digits[i] +=1 ;
				return digits;
			}
			digits[i] = 0;
		}
		int[] newDigits = new int[digits.length +1];
		newDigits[0] = 1;
		return newDigits;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(addOne(new int[]{1,2,3})));
		System.out.println(Arrays.toString(addOne(new int[]{9})));
	
	}

}
