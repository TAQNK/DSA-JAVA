import java.util.ArrayDeque;
import java.util.Deque;

public class StackInJava {

	public static void main(String[] args) {
		// using deque is recommended
		Deque<Integer> stack = new ArrayDeque<>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}
