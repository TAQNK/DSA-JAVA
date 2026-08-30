//The array-form of an integer num is an array representing its digits in left to right order.
//
//For example, for num = 1321, the array form is [1,3,2,1].
//Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
//
// 
//
//Example 1:
//
//Input: num = [1,2,0,0], k = 34
//Output: [1,2,3,4]
//Explanation: 1200 + 34 = 1234
//Example 2:
//
//Input: num = [2,7,4], k = 181
//Output: [4,5,5]
//Explanation: 274 + 181 = 455
//Example 3:
//
//Input: num = [2,1,5], k = 806
//Output: [1,0,2,1]
//Explanation: 215 + 806 = 1021
// Logic : It is also similar to binary string add and sum of num strings to be added just do it for the integer array and a integer . 
// The traversal or int[] from last index getting the elements one by one and adding with key % 10 (last digit) o and carry will store it 
// and in arrayList we have dynamic property to add elements at run-time so we use add () to add elements at 0th index to avoid doing reverse of List to get the answer.
import java.util.ArrayList;
import java.util.List;

public class addIntegerArrayWithKey989 {
	public static List<Integer> addIntegerArrayWithArrayForm(int[] num , int key){
		List<Integer> l = new ArrayList<>();
		int i = num.length -1 , carry = 0;
		while(i >= 0 || key != 0 || carry == 1) {
			if(i >= 0)carry += num[i--];
			if(key > 0) {carry += key % 10; key /= 10;}
			l.add(0 , carry % 10);
			carry /= 10;
		}
		return l;
	}
	public static void main(String[] args) {
		System.out.println(addIntegerArrayWithArrayForm(new int[] {1,2,4,5} , 12));

	}

}
