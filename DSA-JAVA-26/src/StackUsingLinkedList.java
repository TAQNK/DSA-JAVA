public class StackUsingLinkedList {
	static class Node{
		Object data ;
		Node next;
		public  Node(Object data){
			this.data = data;
			next = null;
		}
	}
	Node top ;
	StackUsingLinkedList(){
	}
	
	void push(Object data){
		Node n = new Node(data);
		n.next = top;
		top = n;
	}
	void pop() {
		if(this.isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		System.out.println(top.data);
		top = top.next;
	}
	boolean isEmpty() {
		return top == null;
	}
	Object peek() {
		if(isEmpty()) {
			return -1;
		}
		return top.data;
	}
	public static void main(String[] args) {
		StackUsingLinkedList s1 = new StackUsingLinkedList();
		s1.push(10);
		s1.push(20);
		System.out.println("top -> "+s1.peek());
		while(!s1.isEmpty()) {
			s1.pop();
		}
		

	}

}
