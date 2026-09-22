import java.util.Stack;

public class StackPushAtBottom {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
//		pushAtBottom(4 , s);

		reverseStack(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
		
	}

	static void pushAtBottom(int data, Stack<Integer> s) {
		// recursive function 
		
		// base condition if the top/peek element is null or list is empty 
		// add the data at bottom
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		Integer top = s.pop();// top element
		pushAtBottom(data , s);// return a list with added element at bottom
		s.push(top);//adding the elements back to list
	}
	static void reverseStack(Stack<Integer>s) {
		if(s.isEmpty()) {
			return;
		}
		int top = s.pop();
		reverseStack(s);
		pushAtBottom(top , s);
	}
}
