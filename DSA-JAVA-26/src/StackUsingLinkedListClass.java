import java.util.EmptyStackException;

public class StackUsingLinkedListClass {
	class Node{
		Object data;
		Node next;
		Node(Object value){
			data = value;
			next = null;
		}
	}
	Node top;
	int count;
	StackUsingLinkedListClass(){
		top=null;
		count=0;
	}
	void push(Object value) {
		Node n = new Node(value);
		if(top == null) {
			top = n;
			count++;
			return;
		}
		n.next = top;
		top = n;
		count++;
	}
	Object pop() {
		if(top == null) {
			throw new EmptyStackException();
		}
		Object o= top.data;
		top = top.next;
		count--;
		return o;
	}
	Object peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	boolean isEmpty() {
		return count==0;
	}
	int size() {
		return count;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedListClass s = new StackUsingLinkedListClass();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		System.out.println(s.peek());
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		System.out.println(s.peek());

	}

}
