import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayListClass {
	List<Object> stack = new ArrayList<>();
	int top = -1;
	void push(Object o) {
		top++;
		stack.add(o);
	}
	Object pop() {
		top++;
		return stack.get(top);
	}
	Object peek() {
		return stack.get(top);
	}
	boolean isEmpty() {
		return top == stack.size()-1;
	}
	public static void main(String[] args) {
		StackUsingArrayListClass s = new StackUsingArrayListClass();
		s.push(10);
		s.push(20);
		s.push(30);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}

	}

}
