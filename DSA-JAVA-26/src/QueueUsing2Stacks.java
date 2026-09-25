import java.util.Stack;

public class QueueUsing2Stacks {
	Stack<Object> s1 ;
	Stack<Object> s2 ;
	QueueUsing2Stacks(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}
	void offer(Object value) {
		// first checking if the s1 is empty 
		// if not empty i can move the elements in s2
		// and then enter element in s1
		// then have to move all elements back in s1
		while(! s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(value);
		while(! s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	Object poll() {
		if(s1.isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return s1.pop();
	}
	Object peek() {
		if(s1.isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return s1.peek();
	}
	public static void main(String[] args) {
		
		QueueUsing2Stacks q1 = new QueueUsing2Stacks();
		q1.offer(10);
		q1.offer(20);
		q1.offer(30);
		// 10|20|30
		while(! q1.isEmpty()) {
			System.out.print(q1.poll()+"|");
		}
	}

}
