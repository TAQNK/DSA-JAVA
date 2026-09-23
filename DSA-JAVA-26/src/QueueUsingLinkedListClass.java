
public class QueueUsingLinkedListClass {
	class Node{
		Node next;
		Object data;
		
		Node(Object value){
			data = value;
			next = null;
		}
	}
	Node top;
	int count;
	
	QueueUsingLinkedListClass(){
		top = null;
		count = 0;
	}
	void add(Object value) {
		Node n = new Node(value);
		if(top == null) {
			top = n;
			count++;
			return;
		}
		// add last
		Node curr = top;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = n;
		count++;
	}
	Object poll() {
		// delete the top and return the object data 
		if(top == null) {
			throw new NullPointerException();
		}
		Object key = top.data;
		top = top.next;
		count--;
		return key;
	}
	int size() {
		return count;
	}
	boolean isEmpty() {
		return count==0;
	}
	Object peek() {
		if(top == null) {
			throw new NullPointerException();
		}
		return top.data;
	}
	public static void main(String[] args) {
		QueueUsingLinkedListClass q = new QueueUsingLinkedListClass();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}

	}

}
