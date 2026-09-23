
public class ValidParentheses20 {
	boolean match(String s) {
		char[] c = s.toCharArray();
		if(s.length() %  2 != 0)return false;
		char[] stack = new char[s.length()];
		int head = 0;
		for(int i = 0 ;i < s.length() ; i++) {
			if(c[i] == '{') {
				stack[head++] = '}';
			}else if(c[i] == '(') {
				stack[head++] = ')';
			}else if(c[i] == '[') {
				stack[head++] = ']';
			}else {
				if(head == 0 || stack[--head] != c[i]) {
					return false;
				}
				
			}
		}
		return head==0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
