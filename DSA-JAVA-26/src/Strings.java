
public class Strings {
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
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Java is easy";
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