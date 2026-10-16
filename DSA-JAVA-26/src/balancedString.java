import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class balancedString {
	public static boolean isBalanced(String s) {
//		if(s.isEmpty())return false;
		Deque<Character> st = new ArrayDeque<>();
		for(int i = 0 ; i < s.length() ; i++ )
		{
			if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
				st.push(s.charAt(i));
			}else if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
				if(st.isEmpty() || !isPair(s.charAt(i) , st.pop())) {
					return false;
				}
			}
		}
		return st.isEmpty();
	}
	private static boolean isPair(char charAt, Character pop) {
		if(charAt == '}' && pop == '{' ||charAt == ']' && pop == '[' ||charAt == ')' && pop == '(' ) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isBalanced("{{}}"));

	}

}
