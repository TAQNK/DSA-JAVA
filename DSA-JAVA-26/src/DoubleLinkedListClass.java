
public class DoubleLinkedListClass {
	class Node{
		Node prev;
		Object data;
		Node next;
		
		Node(Object value){
			prev = null;
			data = value;
			next = null;
		}
	}
	Node head;
	int count;
	Node tail;
	DoubleLinkedListClass(){
		head = null;
		count = 0;
		tail = null;
	}
	void addFirst(Object value){
		Node n = new Node(value);
		if(head == null) {
			head = n ;
			tail = n;
			count++;
			return;
		}
		n.next = head;
		head.prev = n;
		head = n;
		count++;
	}
	void addLast(Object value) {
		Node n = new Node(value);
		if(head == null) {
			head = n;
			tail = n;
			count++;
			return;
		}
		n.prev = tail;
		tail.next = n;
		tail = n;
		count++;
	}
	void addAtIndex(int index , Object value) {
		Node n = new Node(value);
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			addFirst(value);
			return;
		}
		if(index == size()) {
			addLast(value);
			return;
		}
		Node curr = head;
		for(int i = 1 ; i < index ; i++) {
			curr = curr.next;
		}
		n.prev = curr;
		n.next = curr.next;
		curr.next.prev = n;
		curr.next = n;
		count++;
	}
	int size() {
		return count;
	}
	boolean isEmpty() {
		return count == 0;
	}
	boolean contains(Object value) {
		if(head == null) {
			throw new NullPointerException();
		}
		Node curr = head;
		while(curr != null) {
			if(curr.data.equals(value)) {
				return true;
			}
		}
		return false;
	}
	void removeFirst() {
		if(head == null) {
			throw new NullPointerException();
		}
		if(head == tail) {
			head = null;
			tail = null;
			count--;
			return;
		}
		head = head.next;
		count--;
	}
	void removeLast() {
		if(head == null) {
			throw new NullPointerException();
		}
		if(head == tail) {
			head = null;
			tail = null;
			count--;
			return;
		}
		tail = tail.prev;
		count--;
	}
	void removeAtIndex(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			removeFirst();
			return;
		}
		if(index == size() - 1) {
			removeLast();
			return;
		}
		Node curr =head;
		for(int i = 1 ; i <= index ; i++) {
			curr = curr.next;
		}
		curr.next.prev = curr.prev;
		curr.prev = curr.next;
		count--;
	}
	void display() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.print("NULL\n");
	}
	void reverseDisplay() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node curr = tail;
		while(curr != null) {
			System.out.print(curr.data+"->");
			curr = curr.prev;
		}
		System.out.print("NULL\n");
	}
	public static void main(String[] args) {
		

	}

}
