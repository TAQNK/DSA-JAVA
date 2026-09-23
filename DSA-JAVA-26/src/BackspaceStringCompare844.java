//Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
//
//Note that after backspacing an empty text, the text will continue empty.
//
// 
//
//Example 1:
//
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
//Example 2:
//
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
//Example 3:
//
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
// 
//
//Constraints:
//
//1 <= s.length, t.length <= 200
//s and t only contain lowercase letters and '#' characters.
// 
//
//Follow up: Can you solve it in O(n) time and O(1) space?
import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare844 {
	public static boolean backspaceCompare(String s, String t) {
		Deque<Character> s1 =new ArrayDeque<>();
		Deque<Character> s2 =new ArrayDeque<>();
		
		for(char c : s.toCharArray()) {
			if(c != '#') {
				s1.push(c);
			}else if (c == '#' && s1.size() == 0) {
				continue;
			}else {
				s1.pop();
			}
		}
		for(char c : t.toCharArray()) {
			if(c != '#') {
				s2.push(c);
			}else if (c == '#' && s2.size() == 0) {
				continue;
			}else {
				s2.pop();
			}
		}
		if(s1.size() != s2.size()) {
			return false;
		}
		while(!s1.isEmpty() && !s2.isEmpty()) {
			if(!s1.pop().equals(s2.pop())) {
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		System.out.println(backspaceCompare("##ab","#ab#b"));

	}

}
