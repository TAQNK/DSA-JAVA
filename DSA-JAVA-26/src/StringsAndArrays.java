import java.util.ArrayList;
import java.util.Arrays;

public class StringsAndArrays {
	public static int countNumberOfWordsInAString(String s) {
//		2 pointer approach
//		int count = 0 ;
//		for(int i = 0 ; i < s.length() ; i++) {
//			if(s.charAt(i) == ' ') {
//				continue;
//			}
//			int j = i;
//			for( ; j<s.length() ; j++) {
//				if(s.charAt(j) == ' ') {
//					count++ ;
//					break;
//				}
//			}
//			i = j;
//		}
//		return count ; 
		
//		1 pointer approach
		int count = 0 ;
		for(int i = 0 ; i < s.length() -1  ; i++) {
			char c = s.charAt(i);
			if(s.charAt(i+1) == ' ' && (( c >= 'a' && c<= 'z' ) || (c >= 'A' && c <= 'Z')) ) {
				count ++;
			}
		}
		return count ;
	}
	
	public static void checkPalindrome(String s) {
		int i = 0 , j = s.length()-1 ;
		boolean flag = true;
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				flag = false;
				break;
			}
			i++;j--;
		}
		if(flag)System.out.println("String is palindrome.");
		else System.out.println("String is not palindrome.");
		
	}
	public static String stringRemoveDuplicates(String s) {
		char[] c = s.toCharArray();
		String res  = "";
		for(int i = 0 ; i < s.length()-1 ;i++){
			if(c[i] == '\u0000')continue ; //to get the space if repeated 
			for(int  j = i+1 ; j < s.length() ; j++) {
				
				if(c[i] == c[j]) {
					c[j] ='\u0000';
				}
			}
			res += c[i];
		}
		return res ;
	}
	public static char[] upperToLowerAndLowerToUpper(String s) {
		char[] ch = s.toCharArray();
		for(int i = 0 ; i < s.length() ; i++) {
			if( ch[i] >= 'a' && ch[i] <= 'z')
				ch[i] -= 32 ;
			
			else if ( ch[i] >= 'A' && ch[i] <= 'Z')
				ch[i] += 32 ;
		}
		return ch;
	}

	public static String reverseStr(String s) {
		int i = 0 , j =0 ;
		String rev = "";
		while( i <= s.length() -1) {
			while(j <= s.length() -1 && s.charAt(j) != ' ') {
				j++;
			}
			int k = j -1 ;
			while(k >= i) 
			{
				rev += s.charAt(k--);
			}
			rev += ' ';
			j ++ ;
			i = j; 
		}
		return rev; 
	}
	// note in output that space is also a char if you dont want it mention it with unicode skip
	public static void letterCountInString(String s) {
		int i = 0 ;
		char[]ch = s.toCharArray();
		while(i<s.length()-1) {
			int j = i+1;
			int count = 1 ;
			// skipping the unicode (default value for blank space != space) as the repeated letters will not be printed
			if(ch[i] == '\u0000') {
				i++;
				continue;
			}
			while(j<s.length()) {
				if(ch[i] == ch[j]) {
					ch[j] = '\u0000';
					count ++;
				}
				j++;
			}
			System.out.println("Letter "+ch[i]+" :"+count);
			i++;
		}
	}
	// same code below different way 
	public static String reverseWords(String s) {
		String rev = "";
		for(int i = 0 ; i< s.length() -1 ; i++) {
			if(s.charAt(i) == ' '){
				rev += ' ';
				continue ;
			}
			int j = i+1 ;
			for(; j< s.length() ;j++) {
				if(s.charAt(j) == ' ') {
					break;
				}
			}
			for(int k = j-1 ; k >= i ; k--) {
				rev += s.charAt(k);
			}
			i = j-1 ;
		}
		return rev;
	}
	public static String reverseSyntax(String s) {
		int i = s.length()-1 ;
		int j = s.length() - 1;
		String rev = "";
		while(i >= 0 ) {
			while(i >= 0 && s.charAt(i) != ' ') {
				i-- ;
			}
			int k = i +1 ;
			while( k <= j) {
				rev += s.charAt(k++);
			}
			rev+=' ';
			i--;
			j =  i;
		}
		return rev;
	}
	public static String nonRepeatedCharsInString(String s) {
		char[] ch = s.toCharArray();
		String str = "";
		for(int i = 0 ; i < s.length()  ; i++) {
			char  c =ch[i];
			int count = 1; 
			if(c == '\u0000')continue ;
			for(int j = i +1 ; j<s.length() ; j++) {
				if(c == ch[j]) {
					ch[j] = '\u0000';
					count ++;
				}
			}
			if(count == 1)str += c;
		}
		
		return str;
	}
	
	public static String duplicateCharsInString(String s) {
		char[] ch = s.toCharArray();
		String str = "";
		for(int i = 0 ; i< s.length() ; i++) {
			char c  = ch[i];
			int count = 1 ;
			if(c == '\u0000')continue ;
			for(int j = i+ 1; j <s.length() ; j++) {
				if(c == ch[j]) {
					ch[j] = '\u0000';
					count ++;
				}
			}
			if(count > 1)str += c;
		}
		return str;
	}
	
	public static String replaceConescutiveSWith$(String s) {
		// BOSSS - > BOS$S
		char[] ch = s.toCharArray();
		String str = "";
		for(int i = 0 ; i <s.length() ; i++) {
			int count = 1 ;
			if(ch[i] == 'S') {
				for(int j = i+1; j  <s.length() ; j++) {
					if( ch[i] == ch[j]) {
						if(count == 1) {
							ch[j] = '$';
							count++;
						}else {
							count--;
						}
					}
				}
			}
			str += ch[i];
		}
		return str ;
		
	}
	
	public static String replaceVowelCount3ORGreaterWith_(String s) {
		char[] ch = s.toCharArray();
		int i = 0;
		int count = 0 ;
		String str = "";
		while(i < s.length() ) {
			char c = ch[i];
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count ++ ;
			}
			i++;
		}
		i=0;
		while(i < s.length() ) {
			char c = ch[i];
			if(count >= 3) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					ch[i] = '_' ;
				}
			}
			str += ch[i];
			i++;
		}
		return str;
	}
		
	public static String  occurenceDuplicateChar(String s) {
		String str = "";
		char ch[]  = s.toCharArray();
		for(int i = 0 ; i < s.length() ; i++){
			char count = '1' ; 
			if(ch[i] >= '0' && ch[i] <= '9') {
				str+=ch[i];
				continue ;
			}//  skip the numbers intialization for ch[i] again 
			for(int j = i +1 ; j  <s.length() ; j++) {
				if(ch[i] == ch[j]) {
					count ++;
					ch[j] = count ; 
				}
			}
			if(count > '1')ch[i] = '1';
			str += ch[i];
		}
		return str;
	}
	
	public static char[] stringInitCap(String s) {
		char ch[] = s.toCharArray();
		for(int i = 0 ; i< s.length() ; i++) {
			if( ch[i] == ' ')continue ;
			if(ch[i] >= 'a'&& ch[i] <= 'z') ch[i] -= 32 ;
			int j = i+1;
			for( ; j <s.length() ; j++) {
				if(ch[j] ==' ') {
					break;
				}
			}
			i = j ; 
		}
		return ch;
	}
	// other simpler way 
	public static char[] stringInitCap2(String s) {
		char [] ch = s.toCharArray();
		for(int i = 0 ; i <s.length() ; i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {
				if( i == 0 ||ch[i-1] == ' ') {
					ch[i] -= 32;
				}
				
			}
		}
		return ch ;
	}
	
	public static char [] encoderDecoder(String s , int n ) {
		char[] ch = s.toCharArray();
		for(int i = 0 ; i < s.length() ;i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] = (char) ((char)((((ch[i] + n - 'a')% 26 )+ 26) % 26) + 'a');
			}

		}
		return ch;
		
	}
	
	public static char[] ascendingOrderString(String s) {
		char[] ch = s.toCharArray();
		for(int i =  0 ; i < s.length() -1 ; i++) {
			for(int j = i +1 ; j < s.length() ; j++) {
				if(ch[i] > ch[j]) {
					char temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp ; 
				}
			}
		}
		return ch ;
		}
	public static char[] descendingOrderString(String s) {
		char[] ch = s.toCharArray();
		for(int i =  0 ; i < s.length() -1 ; i++) {
			for(int j = i +1 ; j < s.length() ; j++) {
				if(ch[i] < ch[j]) {
					char temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp ; 
				}
			}
		}
		return ch ;
		}
	
	public static int occuranceOfkeyInString(String s,  char key) {
		for(int  i = 0 ; i <s.length() ; i++) {
			if(s.charAt(i) == key) {
				return i;
			}
		}
		return -1 ;
	}
	public static boolean isStringPanagram(String s) {
		s = s.toLowerCase();
		if(s.length() < 26)return false;
		s = s.toLowerCase();
	
		for(char c = 'a' ; c <= 'z'; c++) {
			if(!s.contains(c+"")) {
				return false;
			}
		}
		return true;
		
	}
	
	public static String removeDuplicateUsingStringBuildMethod(String s) {
		String ans= "";
		s = s.toLowerCase();
		for(int i = 0 ; i <s.length() ; i ++) {
			if(ans.contains(s.charAt(i)+"")){
				continue ;
			}
			ans += s.charAt(i);
			
		}
		
		return ans ;
	}
	
	public static String printingMissingVowels(String s) {
		String missing = "";
		String vowels = "aeiou";
		s = s.toLowerCase();
			for(int j = 0 ; j  <vowels.length() ; j++) {
				if(!s.contains(vowels.charAt(j) +"")) {
					missing += vowels.charAt(j);
				}
			}
			
		return missing ; 
		
	}
	public static String swap(String s , int i , int j) {
		char[] ch = s.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp; 
		String ans = "";
		for(char c : ch) {
			ans += c;
		}
		return ans ;
	}
	
	public static void printPermutation(String s , int st , int end) {
		if(st == end) {System.out.println(s); return;}
		
		for(int i = st ; i <= end ;i++) { 
			String s1 = swap(s , st , i);
			printPermutation(s1 , st+1 , end);
		}
	}
	
	public static String reverseTheWordsPlacementUsingSplit(String s) {
		String[] strArr = s.split(" ");
		String rev = "";
		for(int i = strArr.length -1 ; i >= 0 ; i--) {
			rev += strArr[i];
			rev += " ";
		}
		return rev.trim();
	}
	
	public static String reverseTheWordsOfAGivenStringUsingSplit(String s) {
		String[] strArr = s.split(" ");
		String rev = "";
		for(String str : strArr) {
			for(int i = str.length() - 1 ; i >= 0 ; i--) {
				rev += str.charAt(i);
			}
			rev += " ";
		}
		return rev.trim();
	}
	public static void printPalindormsInStringUsingSplit(String s) {
		String[] strArr = s.split(" ");
		for(String str : strArr) {
			int i = 0 ;
			int j = str.length() - 1;
			boolean flag = true;
			while(i < j) {
				if(str.charAt(i) != str.charAt(j)) {
					flag = false;
					break;
				}
				i ++;
				j --;
			}
			if(flag)
			System.out.println(str);
		}
	}
	public static void printBiggestPalindromInStringUsingSplit(String s) {
		String[] strArr = s.split(" ");
		String biggestPalindrome = "";
		for(String str : strArr) {
			int i = 0 ;
			int j = str.length() - 1;
			boolean flag = true;
			while(i < j) {
				if(str.charAt(i) != str.charAt(j)) {
					flag = false;
					break;
				}
				i ++;
				j --;
			}
			if(flag)
			{
				if(biggestPalindrome.length() < str.length()) {
					biggestPalindrome = str;
				}
			}
		}
		System.out.println(biggestPalindrome);
	}
	public static String removingDuplicatesFromStringUsingSplit(String s) {
		String[] str= s.split(" ");
		String res= "";
		for(int i = 0 ; i < str.length ; i++) {
			if(!res.contains(str[i])) {
				res += str[i] + " ";
			}
		}
		return res.trim();
	}
	public static void printingTheOcuurenceOfWordsUsingSplit(String s) {
		String [] str = s.split(" ");
		for(int i = 0 ; i  < str.length ; i++) {
			int count = 1; 
			if(str[i] == " ")continue;
			for(int j = i +1 ; j < str.length ; j++) {
				if(str[i].equals(str[j])) {
					count ++;
					str[j] =" ";
				}
			}
			System.out.println(str[i] +"=" + count);
		}
	
		
	}
	
	public static String nonRepeatingWordsInAGivenString(String s) {
		String[] strArr = s.split(" ");
		String answer = "";
		for(int i = 0 ; i < strArr.length ; i++) {
			int count = 1;
			if(answer.contains("\u0000"))continue;
			for(int j = i + 1; j < strArr.length ; j++) {
				if(strArr[i].equals(strArr[j])) {
					count ++;
					strArr[j] = "\u0000";
				}
			}
			if(count == 1)
				answer += strArr[i] +" ";
		}
		return answer;
	}
		
	// printing is the two given strings are anagram or not having the same char
	public static boolean isAnagram(String s1 , String s2) {
		if(s1.length() != s2.length())return false;
		if(s1.length() == 0 && s2.length() == 0) return true;
		char ch = s1.charAt(0);
		return isAnagram(s1.replace(ch +"", "")  , s2.replace(ch +"", ""));
	}
	//printing the occurence of each letter 
	public static void printOccurrenceOfEachLetterInStringUsingBuiltInMethods(String s) {
		String s1 = s;
		String s2 = "";
		while(s1.length() != 0) {
			char ch= s1.charAt(0);
			s2 = s1.replace(ch +"", "");
			int count = s1.length() - s2.length();
			System.out.println(ch +" : "+count);
			s1 = s2;
		}
	}
	
	// printing the max occurred char in string 
	public static void printingMaxOccurredCharInString(String s) {
		int max = 0 ;
		char  maxChar = ' ';
		String s2 = "";
		while(s.length() > 0) {
			char ch = s.charAt(0);
			s2 = s.replace(ch+"" , "");
			int count = s.length() - s2.length();
			if(count > max) {max = count ; maxChar = ch;}
			s = s2 ;
		}
		System.out.println(maxChar+" = "+max);
		
	}
	public static void printingMinOccurredCharInString(String s) {
		int min = s.length() ;
		char  minChar = ' ';
		String s2 = "";
		while(s.length() > 0) {
			char ch = s.charAt(0);
			s2 = s.replace(ch+"" , "");
			int count = s.length() - s2.length();
			if(count < min) {min = count ;minChar = ch;}
			s = s2 ;
		}
		System.out.println(minChar+" = "+min);
		
	}
	
	//input - Ram12nak53um3 output - 67
	public static int  getSumOfNumbers(String s) {
		int sum = 0 ;
		//i found the first integer so i am skipping all char other than 0 -9
		for(int i = 0 ; i < s.length(); i++)
		{	String num = "";
			while(i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				i++;
			}
		// now i have to find the length of number
			int j = i + 1;
			while( j  < s.length() && (s.charAt(j) >= '0' && s.charAt(j) <= '9')){
				j++;
			}
			int k = i ;
			while(k < j) {
				num+= s.charAt(k);
				k++;
			}
			int l = num.length() -1 ;
			int place = 1;
			System.out.println("num"+num +" , sum:"+sum);
			while(l  >= 0) {
				int digit = (num.charAt(l) -'0') * place;
				place *=10;
				sum += digit;
				l--;
			}
			i = j;
		}
		// number lies in i -> j -1
		// now form this number and add it to sum
		return sum ;
	}
	
	// find all substrings
	public static void printSubstrings(String s) {
		for(int i = 0 ; i <s.length() ; i++) {
			for(int j = i + 2 ; j < s.length() ; j++) {
				System.out.println(s.substring(i , j));
			}
		}	
	}
	
	//find all the palindoromes exisiting in malayalam
	public static void findPalindromes(String s) {
		for(int i = 0 ; i < s.length() ;  i ++) {
			for(int j = i + 2; j < s.length() ; j++) {
				if(isPalindrome1(s.substring(i , j))) {
					System.out.println(s.substring(i , j));
				}
			}
		}
	}
	//helper function 
	public static boolean isPalindrome1(String s) {
		int i = 0 , j = s.length() - 1 ;
		while( i < j ) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	// finding the max possible palindrme in malayalam
	public static void maxPalindrome(String s) {
		String maxPalindrome = "";
		for(int i = 0 ; i < s.length() ; i++) {
			for(int j = i + 2 ; j < s.length() ; j++) {
				String str = s.substring(i ,j);
				if(isPalindrome1(str)) {
					if(maxPalindrome.length() < str.length()) {
						maxPalindrome = str;
					}
				}
			}
		}
		System.out.println("Max Palindrome string possible in "+ s +" is "+maxPalindrome+" .");
	}
	// minimun palindrome
	public static void minPalindrome(String s) {
		String minPalindrome = s;
		for(int i = 0 ; i < s.length() ; i++) {
			for(int j = i + 2 ; j < s.length() ; j++) {
				String str = s.substring(i ,j);
				if(isPalindrome1(str)) {
					if(minPalindrome.length() > str.length()) {
						minPalindrome = str;
					}
				}
			}
		}
		System.out.println("Min Palindrome string possible in "+ s +" is "+minPalindrome+" .");
	}
	//swapping two strings without using third variable
	public static void swap_2V(String s1 , String s2) {
		
		System.out.println("String 1 = "+s1);
		System.out.println("String 2 = "+s2);
		System.out.println("After Swap ");
		s1 = s1 + s2;
		s2 = s1.substring(0 , s1.length() - s2.length());
		s1 = s1.substring(s2.length());
		System.out.println("String 1 = "+s1);
		System.out.println("String 2 = "+s2);
	}
	// input - "banana" output - b- 0 , a - 1 ,3,5  , n - 2 , 4 
	public static void printIndexValueOfOccurences(String s) {
		String temp = "";
		for(int i = 0 ; i < s.length() ; i++) {
			if(temp.contains(s.charAt(i) +""))continue;
			
			System.out.print(s.charAt(i) + " : " +i);
			for(int j = i + 1 ; j  < s.length() ; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					temp += s.charAt(i);
					System.out.print(", "+j);
				}
			}
			System.out.println();
		}
	}
	
	// removing duplicates form the array - 2pointer approach
	public static void removeDuplicates(int[] nums) {
		for(int i = 0 ; i < nums.length ; i++) {
			boolean flag = true;
			for(int j  = 0 ; j < i ; j++) {
				if(nums[i] == nums[j]) {
					flag = false;
					break;
				}
			}
			if(flag)System.out.print(nums[i] + " ");
		}
		System.out.println(); 
	}
	// now the same thing of removing duplicates but return the result 
	public static int[] removeDuplicates1(int[] nums) {
		int [] res  ;
		String s ="";
		for(int i = 0 ; i < nums.length ; i++) {
			boolean flag = true;
			for(int j  = 0 ; j < i ; j++) {
				if(nums[i] == nums[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				s += digitToString(nums[i])+" ";
			}
		}
		
		String  numStr[] =  s.split(" ") ;
		
		res = new int[numStr.length];
		for(int i = 0 ; i < res.length ; i++) {
			res[i] = Integer.parseInt(numStr[i]);
		}
		return res;
	}
	private static String digitToString(int i) {
		// TODO Auto-generated method stub
		String res = "";
		while(i != 0) {
			res  = (char)(i%10 + '0') + res;
			i /= 10;
		}
		return res;
	}

	public static int[] sumOf2UnqualArrays(int[] a, int[] b) {
		int minLen = a.length < b.length ? a.length : b.length;
		for(int i = 0 ; i < minLen ; i++) {
			if(a.length < b.length)a[i] += b[i];
			else b[i] += a[i];
		}
		return a.length < b.length ? b : a;
	}
	public static int maxElementInArray(int[] arr) {
		int max = 0;
		for(int i : arr) {
			if(max < i)max = i;
		}
		return max;
	}
	public static int secondMaxElementInArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int element : arr) {
			if(element > max) {
				secondMax = max;
				max = element;
			}
			else if(element > secondMax && max > element)
				secondMax = element;
		}
		return secondMax;
	}
	public static int minElementInArray(int [] arr) {
		int min = Integer.MAX_VALUE;
		for(int e : arr) {
			if(e < min)min = e;
		}
		return min;
	}
	public static int secondMinElement(int[] arr) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for(int i = 0 ; i < arr.length ; i++) {
			if(min > arr[i]) {
				secondMin = min;
				min = arr[i];
			}else if (secondMin < arr[i] && arr[i] > min) {
				secondMin = arr[i];
			}
		
		}
		return secondMin;
		}
	
	// linearSearch
	public static  int LinearSearch(int [] arr , int key) {
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] == key)return i;
		}
		return -1;
	}
	
	public static int BinarySearch(int[] a , int dhudhMughea) {
		int i = 0 , j = a.length - 1;
		
		while(i <= j) {
			
			int mid = (i + j)/2;
			
			if(a[mid] == dhudhMughea)
				return mid;
			
			else if(a[mid] < dhudhMughea) {
				
				i = mid + 1;
				
			}else {
				
				j = mid - 1;
				
			}
		}
		return -1;
	}
	public static int BinarySearchRecursion(int []a , int st , int end , int dhudhMughea) {
		if(st > end)return -1;
		int mid = ( st + end )/2;
		
		if(a[mid] == dhudhMughea)
			return mid;
		
		else if(a[mid] > dhudhMughea)
			return BinarySearchRecursion(a,st , mid - 1 , dhudhMughea);
		
		return BinarySearchRecursion(a, mid + 1 , end, dhudhMughea);
	}
	
	public static int[] BubbleSort(int[] a) {
		for(int i = a.length - 1 ; i > 0 ; i--) {
			for(int j = 0 ; j < i ; j++) {
				
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	public static int[] SelectionSort(int []a ) {
		// find the min and place them at start
		for(int i = 0 ; i < a.length - 1 ; i++) {
			
			int min = i ;
			
			for(int j = i + 1 ; j < a.length ; j++) {
				
				if(a[j] < a[min])min = j;
				
			}
			
			int temp = a[i];
			a[i] = a[min] ;
			a[min] = temp;
			
		}
		return a;
	}
	public static int[] InsertionSort(int []a ) {
		// find the actual positon of element elements on right of it should be big and on left small
		for(int i = 1 ; i < a.length ; i++) {
			
			int j = i ;
			
			while( j > 0 ) {
				
				if(a[j-1] > a[j]) {
					
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
					
				}
				j--;
			}
		}
		return a;
	}
	
	// merge sort
	public static void MergeSort(int a[] , int low , int high) {
		if(low >= high)return;
		
		int mid = (low + high) / 2;
		MergeSort(a , low , mid);
		MergeSort(a , mid + 1 , high);
		Merge(a , low , mid , high);
	}
	
	
 	private static void Merge(int[] a, int low, int mid, int high) {
		int temp[] = new int[high - low + 1];
		int k = 0;
		int left = low , right = high ;
		while(left <= mid && right <= high) {
			
			while(a[left] <= a[right]) {
	
				temp[k++] = a[left++];
				
			}
			while(a[left] > a[right]) {
				
				temp[k++] = a[right++];
				
			}
			
		}
		// remaining elements in both arrays 
		while(left <= mid)temp[k++] = a[left++];
		while(right <= high)temp[k++] = a[right++];
		
		//copy elements back to original array
		for(int l = low ; l <= high ; l++) {
		
			a[l] = temp[l-low];
			
		}
		
	}
 	
 	// quick sort
 	public static void QuickSort(int[]a , int low , int high) {
 		int pivot = (low + high )/2;
 		if(low > high)return;
 		int i = low , j = high;
 		if(i <= j) {
 			while(a[i] < a[pivot]) {
 				i ++;
 			}
 			while(a[j] > a[pivot]) {
 				j --;
 			}
 		}
 		if( i <= j) {
 			int temp = a[i];
 			a[i] = a[j];
 			a[j] = temp;
 			i++;
 			j--;
 		}
 		QuickSort(a, low , j);
 		QuickSort(a, i , high);
 	}

 	// 2d array 
 	public static int secondMaxIn2DArray(int[][] a) {
 		
 		int max = Integer.MIN_VALUE , secondMax = Integer.MIN_VALUE;
 		
 		for(int i = 0 ; i < a.length ; i++) {
 			
 			for(int j = 0 ; j < a[i].length ; j++) {
 				
 				if(a[i][j] > max) {
 					secondMax = max ;
 					max = a[i][j];
 				}else if(a[i][j] > secondMax) {
 					secondMax = a[i][j];
 				}
 			}
 		}
 		return secondMax ;
 	
 	}
 	
 	
 	public static int sumOfDiagonalElements1(int[][] a){
 		
 		int sum = 0 ;
 		for(int i =0 ; i < a.length ; i++) {
 			
 			for(int j = 0 ; j < a[i].length; j++) {
 				
 				if(i == j || i+j == a.length - 1 ) {
 					sum += a[i][j];
 				}
 			}
 		} 	
 		
 		return sum;
 				
 	}
 	// now using a single loop
 	public static int sumOfDiagonalElements2(int[][]a) {
 		int sum = 0;
 		for(int i = 0 ; i < a.length ; i++ ){
 			sum += a[i][i];
 			// this only works not the length /2
 			if(i != a.length -i-1) {
 				sum += a[i][a.length - i - 1];
 			}
 		}
 		return sum;
 	}
 	
 	
 	// 2d arrays 
 	// spiral matrix 
 	// [1,2,3,4,5]
 	// [16,17,18,19,6]
 	// [15,24,25,20,7]
 	// [14,23,22,21,8]	
 	// [13,12,11,10,9]
 	
 	public static void SpiralMatrix(int[][] a) {
 		int row = 0;
 		int col = -1;
 		char dir = 'R';
 		
 		for(int i = 1 ; i <= a.length*a.length ; i++) {
 			
 			switch(dir) {
 			
 				case 'R':{
 					col++;
 					a[row][col] = i;
 					if(col == a.length -1 || a[row][col+1] !=0)
 						dir = 'D';
 				}
 				break;
 				case 'D':{
 					row++;
 					a[row][col] = i;
 					if(row == a.length -1 || a[row+1][col] !=0)
 						dir = 'L';
 				}
 				break;
 				case 'L':{
 					col--;
 					a[row][col] = i;
 					if(col == 0 || a[row][col-1] !=0)
 						dir = 'U';
 				}
 				break;
 				case 'U':{
 					row--;
 					a[row][col] = i;
 					if(row == 0 || a[row-1][col] !=0)
 						dir = 'R';
 				}
 				break;
 			}
 		}
 		
 	}
 	
 	// transpose matrix
 	public static int[][] TransposeMatrix(int[][]a) {
 		int [][]b = new int[a.length][a[0].length];
 		for(int  i = 0 ; i < a.length ; i++) {
 			for(int j = 0 ; j < a[i].length ; j++) {
 				b[i][j] = a[j][i];
 			}
 		}
 		return b;
 	}
 	// pascal triangle 
 	// 1 . 
 	//11
 	//121
 	//1331
 	//14641
 	
 	public static int[][] PascalTriangle(int num ) {
 		int[][]pascalTriangle = new int[num ][];
 		for(int i = 0 ; i < num ; i++) {
 			int[]row = new int[i+1];
 			row[0]= 1;
 			for(int j = 1 ; j <= i ; j++) {
 				if( j == i ) {
 					row[j] = 1;
 				}else {
 					row[j] = pascalTriangle[i-1][j] + pascalTriangle[i-1][j-1];
 				}
 			}
 			pascalTriangle[i]= row;
 		}
 		return pascalTriangle;
 	}
 	// matrix multiplication
 	public static int[][] MatrixMultiplication(int[][]a ,int [][]b){
 		
 		if(a.length != b.length)return new int[a.length][];
 		int [][] c= new int[a.length][a[0].length];
 		for(int i = 0 ; i < a.length ; i++) {
 			
 			for(int j = 0 ;j < a[i].length ; j++) {
 				
 				for(int k = 0 ; k < a.length ; k++) {
 					
 					c[i][j] += a[i][k] + b[k][j];
 					
 				}
 			}
 		}
 		
 		return c;
 	}
	public static void main(String[] args) {

//		String s = "Java is easy";
//		System.out.println(reverseSyntax(s));
//		System.out.println(reverseStr(s));
//		String s = "  Ja  VVa iis easuu  "; //Jav iseiu
//		System.out.println(stringRemoveDuplicates(s));
//		System.out.println(upperToLowerAndLowerToUpper(s));
//		System.out.println(countNumberOfWordsInAString(s));
//		checkPalindrome("madam");
//		System.out.println(reverseWords("  java is  easy"));
//		letterCountInString(s);
//		System.out.println(nonRepeatedCharsInString("j  easy"));
//		System.out.println(duplicateCharsInString("jjjava "));
//		System.out.println(replaceConescutiveSWith$("SAVASSAS"));
//		System.out.println(replaceVowelCount3ORGreaterWith_("jvdev"));
//		System.out.println(occurenceDuplicateChar("ramanaa kumar"));
//		System.out.println(stringInitCap2("java is easy heellooe eqwe  eqwew qwe"));
//		System.out.println(encoderDecoder("Hi i am tanihsq.!!!" , 3));
//		System.out.println(encoderDecoder("Hl l dp wdqlkvt.!!!" ,-3));
//		System.out.println(ascendingOrderString("azuma"));
//		System.out.println(descendingOrderString("azuma"));
//		System.out.println(occuranceOfkeyInString("azuma", 'u'));
//		System.out.println(occuranceOfkeyInString("azuma", 'k'));
//		System.out.println(isStringPanagram("my name is tanishq"));
//		System.out.println(removeDuplicateUsingStringBuildMethod("Java is easy"));
//		System.out.println(printingMissingVowels("Am Indian"));
//		printPermutation("abc" , 0 , 2);
//		System.out.println(reverseTheWordsPlacementUsingSplit("java is easy"));
//		System.out.println(reverseTheWordsOfAGivenStringUsingSplit("java is easy"));
//		printPalindormsInStringUsingSplit("madam is from malayalam");
//		printBiggestPalindromInStringUsingSplit("madam knows only malayalam");
//		printingTheOcuurenceOfWordsUsingSplit("java is very very easy java");
//		System.out.println(removingDuplicatesFromStringUsingSplit("Happy Happy Happyness Happy birthday to you"));
//		System.out.println(nonRepeatingWordsInAGivenString("java is very very easy java java"));
//		System.out.println(isAnagram("keep" , "peek"));
//		printOccurrenceOfEachLetterInStringUsingBuiltInMethods("java is easy");
//		printingMinOccurredCharInString("java is very very easy");
//		printingMaxOccurredCharInString("jaavvaaiiaas");
//		System.out.println(getSumOfNumbers("jab12jaba12jaba12"));
//		printSubstrings("malaylam");
//		findPalindromes("malayalam");
//		minPalindrome("malayalam");
//		maxPalindrome("malayalam");
//		swap_2V("tan","pal");
//		printIndexValueOfOccurences("banana+");
//		removeDuplicates(new int[]{1,2,1,2,34,56,633,24,5});
//		System.out.println(Arrays.toString(removeDuplicates1(new int[]{1,2,1,24,5})));
 		
//		System.out.println(BinarySearch(new int[] {1,2,3,4,54} , 4));
//		System.out.println(BinarySearchRecursion(new int[] {1,2,3,45,47} , 0 , 4 , 45));
//		System.out.println(Arrays.toString(BubbleSort(new int[] {1,34,552,12,4,5})));
//		System.out.println(Arrays.toString(SelectionSort(new int[] {1,34,552,12,4,5})));
//		System.out.println(Arrays.toString(InsertionSort(new int[] {1,34,552,12,4,5})));
//		int[]a = {5,4,3,2,1};
//		QuickSort(a , 0 , a.length - 1);
//		System.out.println(Arrays.toString(a));
//		
//		int[][] a1 = {{1,2,3} , {4,5,6} , {7,8,9}};
//		for(int[] a : a1) {
//			for(int n : a) {
//				System.out.print(n+" ");
//			}
//			System.out.println("\n");
//		}
//		System.out.println("Second Max:" + secondMaxIn2DArray(a1));
//		System.out.println("Sum of diagonal elements:" + sumOfDiagonalElements(a1));
//		int[][] a = new int[5][5];
//		SpiralMatrix(a);
//		for(int []i : a) {
//			for(int num :i) {
//				System.out.print(num +" ");
//			}
//			System.out.println();
//		}
//		int[][]a1 = {{1,2,3},{4,5,6},{7,8,9}};
//		for(int []n :TransposeMatrix(a1) ) {
//			for(int num : n) {
//				System.out.print(num+" ");
//			}
//			System.out.println();
//		}
// 	}
		// sum of diagonals using single for loop
	int a1[][] = {{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,1}};
	for(int []arr : a1) {
		for(int num : arr) {
			System.out.print(num);
		}
		System.out.println();
	}
	System.out.println(sumOfDiagonalElements2(a1));
	int[][]a  = {{1,2,3},{5,4,7},{4,5,5}};
	for(int[] arr : MatrixMultiplication(a,a)) {
		for(int num : arr) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
	int num = 5;
	for(int[] row : PascalTriangle(num)) {
		for(int number : row) {
			System.out.print(number +" ");
		}
		System.out.println();
	}
	}
	
}

//assignment questions 
//question - non repeating char in a given string 
//input - java output - jv

//question - to print duplicate char in a given string 
//input java  output a

//question  - input - BOSS output BOS$  
//input  - BOSSSS -  ouptut - BOS$S$ consecutive char to dollar 

//question - vowel char to _(underscore)  if vowel count >= 3 
//input  - javadev output - j_v_d_v
//input - java output - java 


// question  - printing the missing vowel in the given string
// input : "Am Indian" output : "EOUeon"