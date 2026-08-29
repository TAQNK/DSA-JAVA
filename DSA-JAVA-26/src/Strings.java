
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
		while( j <= s.length() -1) {
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
		System.out.println(isStringPanagram("my name is tanishq"));
		System.out.println(removeDuplicateUsingStringBuildMethod("Java is easy"));
		System.out.println(printingMissingVowels("Am Indian"));
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