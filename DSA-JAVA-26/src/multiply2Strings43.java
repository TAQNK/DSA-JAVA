//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
// 
//
//Example 1:
//
//Input: num1 = "2", num2 = "3"
//Output: "6"
//Example 2:
//
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// Logic : Basic ELementry Level 
// Having the digits of second number to be multiplied with the digits of first number and then storing each result in arrayList<ArryList>> with 0's based on the index and then adding all the results one by one.
import java.util.ArrayList;

public class multiply2Strings43 {
	
	public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder str1 = new StringBuilder(num1);
        StringBuilder str2 = new StringBuilder(num2);
        str1.reverse();str2.reverse();
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for(int i = 0 ; i < str2.length() ; i++){
            results.add(
                multiplyOneDigit(str1 , str2.charAt(i) , i)
            );
        }
        StringBuilder answer = addResults(results);
        answer.reverse();
        return answer.toString();
    }
    public static ArrayList<Integer> multiplyOneDigit(
        StringBuilder firstNum ,
        char secondDigit ,
        int zeros){
            ArrayList<Integer> answer = new ArrayList<>();
            for(int i = 0 ; i < zeros ; i++){
                answer.add(0);
            }

            int carry = 0;

            for(int i = 0; i < firstNum.length(); i++){
                carry += (firstNum.charAt(i) - '0') * (secondDigit - '0');
                answer.add(carry % 10);
                carry /= 10;
            }
            if(carry != 0)answer.add(carry);
            return answer;
        }
        public static StringBuilder addResults(ArrayList<ArrayList<Integer>> results){
            ArrayList<Integer> answer = new ArrayList<>(results.get(results.size() - 1));
            ArrayList<Integer>newAnswer = new ArrayList<>();

            for(int i = 0; i < results.size() - 1; i++){
                ArrayList<Integer> result = new ArrayList<>(results.get(i));
                newAnswer = new ArrayList<>();

                int carry = 0;
                for(int j = 0; j < results.size() || j < answer.size() ; j++){
                    carry += j < result.size() ? result.get(j) : 0;
                    carry += j < answer.size() ? answer.get(j) : 0;

                    newAnswer.add(carry % 10);
                    carry /= 10;
                } 

                if(carry != 0)newAnswer.add(carry);
                answer = newAnswer;
            }
            StringBuilder finalAnswer = new StringBuilder();
            for(int digit : answer){
                finalAnswer.append(digit);
            }
            return finalAnswer;

        }
	public static void main(String[] args) {
		System.out.println(multiply("123","10"));

	}

}
