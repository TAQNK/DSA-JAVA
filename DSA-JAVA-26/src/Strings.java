
public class Strings {

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Java is easy";
		System.out.println(reverseSyntax(s));
		System.out.println(reverseStr(s));
	}

}
