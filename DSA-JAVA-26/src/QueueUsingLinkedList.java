
public class QueueUsingLinkedList {
	class Node{
		Node next;
		Object data;
		
		Node(Object value){
			data = value;
			next = null;
		}
	}
	private Node front; // head
	private Node rear; //tail
	private int count;
	QueueUsingLinkedList(){
		front = null;
		rear = null;
		count = 0;
	}
	boolean isEmpty() {
		return count == 0;
	}
	int size() {
		return count;
	}
	void offer(Object value) {
		Node n = new Node(value);
		if(isEmpty()) {
			front = rear = n;
			count++;
			return;
		}
		rear.next = n;
		rear = n;
		count++;
		// O(1)
	}
	Object poll() {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		if(front == rear) {
			rear = null;
		}
		Object key = front.data;
		front = front.next;
		count--;
		return key;
	}
	Object peek() {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		return front.data;
	}
	void display() {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		Node curr = front;
		while(curr != null) {
			System.out.print(curr.data+"|");
			curr = curr.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		QueueUsingLinkedList q1 = new QueueUsingLinkedList();
		q1.offer(10);
		q1.offer(20);
		q1.offer(30);
		q1.display();
		q1.poll();
		q1.display();
		System.out.println(q1.peek());

	}

}
