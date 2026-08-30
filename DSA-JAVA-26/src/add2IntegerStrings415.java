//Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
//
//You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
//
// 
//
//Example 1:
//
//Input: num1 = "11", num2 = "123"
//Output: "134"
//Example 2:
//
//Input: num1 = "456", num2 = "77"
//Output: "533"
//Example 3:
//
//Input: num1 = "0", num2 = "0"
//Output: "0"
// Logic : It is same as adding the 2 binary strings but instead of doing %2 of carry while string the answer to stringBuilder object will do %10 and divide by 10 instead of /2 for carry calculation.
public class add2IntegerStrings415 {
	public static String add2IntegerStrings(String s1 , String s2) {
		int i = s1.length() - 1 ,j = s2.length() - 1, carry = 0 ;
		StringBuilder sb = new StringBuilder();
		while(i >= 0 || j >= 0 || carry == 1) {
			if(i >= 0)carry += s1.charAt(i--) - '0';
			if(j >= 0)carry += s2.charAt(j--) - '0';
			sb.append(carry % 10);
			carry /= 10;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(add2IntegerStrings("9810" , "231"));

	}

}
