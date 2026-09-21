
public class CircularDoublyLinkedList {
	int count ;
	Node head;
	Node tail;
	CircularDoublyLinkedList(){
		head = null;
		tail = null;
		count=0;
	}
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
	void addFirst(Object value) {
		Node n = new Node(value);
		if(head == null) {
			n.next = n;
			n.prev = n;
			head = n;
			tail = n;
			count++;
			return;
		}
		n.prev = tail;
		n.next = tail.next;
		tail.next = n;
		head.prev = n;
		head = n;
		count++;
	}
	void addLast(Object value) {
		Node n = new Node(value);
		if(head == null) {
			n.next = n;
			n.prev = n;
			head = n;
			tail = n;
			count++;
			return;
		}
		n.next = head;
		n.prev = tail;
		head.prev = n;
		tail.next = n;
		tail = n;
		count++;
	}
	void addAtIndex(int index , Object value) {
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
		while(index - 1 > 0) {
			index--;
			curr = curr.next;
		}
		Node n = new Node(value);
		n.prev = curr;
		n.next = curr.next;
		curr.next.prev = n;
		curr.next = n;
		count++;
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
		
		tail.next = head.next;
		head.next.prev = head.prev;
		head = head.next;
		count --;
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
		tail.prev.next = head;
		head.prev = tail.prev;
		tail = tail.prev;
		count--;
	}
	int size() {
		return count;
	}
	boolean isEmpty() {
		return count==0;
	}
	boolean contains(Object value) {
		if(head == null) {
			throw new NullPointerException();
		}
		Node curr = head;
		while(curr.next != head) {
			if(curr.data.equals(value)) {
				return true;
			}
			curr = curr.next;
		}
		// last node or tail node
		if(curr.data.equals(value)) {
			return true;
		}
		return false;
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
		Node curr = head;
		while(index - 1 > 0) {
			index --;
			curr = curr.next;
		}
		curr.next.next.prev = curr;
		curr.next = curr.next.next;
		count--;
	}
	void printForward() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node curr = head;
		while(curr.next != head) {
			System.out.print(curr.data+"->");
			curr = curr.next;
		}
		System.out.print(curr.data+"\n");
	}
	void printBackward() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node curr = tail;
		while(curr.prev != tail) {
			System.out.print(curr.data+"->");
			curr = curr.prev;
		}
		System.out.print(curr.data+"\n");
	}
	public static void main(String[] args) {
		CircularDoublyLinkedList cDList = new CircularDoublyLinkedList();
		cDList.addFirst(10);
		cDList.addFirst(20);
		cDList.addFirst(30);
		cDList.addLast(0);
		cDList.addLast(-10);
		cDList.printForward();
//		cDList.addAtIndex(5, 30);
//		cDList.removeFirst();
		cDList.printForward();
		cDList.removeLast();
		cDList.removeAtIndex(3);
		cDList.printForward();
		cDList.printBackward();
//		System.out.println(cDList.contains(560));
	}

}
