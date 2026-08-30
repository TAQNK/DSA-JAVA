//Given two binary strings a and b, return their sum as a binary string.
//
// 
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"

//Logic :
//Move in both strings based on their lengths and if i have a carry i will also move to add 
// then if str1 has some elements to be added i will add it to carry and same with str2 and move the pointer in str to left 
// and if the sum 1+1 = 2 meaning (10) i will append the stringBuilder object with the carry%2 if 2 = 0 and 1  = 1 and 0 = 0 
// and change the carry to /2 as the carry for sum 2 will be 1 and for 1 and 0 is 0.
// and when returning answer i will reverse the stringBuilder object and print the string 
public class add2BinaryStrings67 {
	public static String add2BinaryStrings(String s1 ,String s2) {
		int i = s1.length()-1 ,j = s2.length()-1 , carry = 0 ;
		StringBuilder sb = new StringBuilder();
		while(i >= 0 || j >= 0 || carry == 1) {
			if(i >= 0)carry += s1.charAt(i--) - '0';
			if(j >= 0)carry += s2.charAt(j--) - '0';
			sb.append(carry % 2);
			carry /= 2;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(add2BinaryStrings("1011" , "1010"));
		System.out.println(add2BinaryStrings("1" , "11"));
	}

}
