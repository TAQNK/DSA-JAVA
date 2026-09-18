import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
	List<Object> list = new ArrayList<>();
	
	boolean isEmpty() {
		
		return list.size() == 0;
		
	}
	void push(Object data) {
		
		list.add(data);
		
	}
	Object pop() {
		 Object top = list.get( list.size() - 1 );
		 list.remove( list.size() - 1 );
		 
		 return top;
	}
	
	Object peek() {
		if(isEmpty())return -1;
		return list.get(list.size() - 1);
	}
	
	public static void main(String args[]) {
		StackUsingArrayList s = new StackUsingArrayList();
		System.out.println(s.peek());
		s.push(10);
		s.push(20);
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
	}
	
}
