
public class DoubleLinkedList1 {
	Node head;
	Node tail;
	int count ;
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
	
	DoubleLinkedList1(){
		head = null;
		tail = null;
		count = 0;
	}
	
	void addFirst(Object value) {
		Node n = new Node(value);
		// list is empty
		if(head == null) {
			head = n;
			tail = n;
			count ++;
			return;
		}
		// list having elements
		n.next = head;
		head.prev = n;
		head = n;
		count++;	
	}
	void addLast(Object value) {
		Node n = new Node(value);
		// list is empty
		if(tail == null) {
			head = n;
			tail = n;
			count ++;
			return;
		}
		// list having elements
		n.prev = tail;
		tail.next = n;
		tail = n;
		count++;
	}
	void addAtIndex(Object value , int index) {
		if(index <0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			addFirst(value);
			return;
		}
		if(index == size()-1) {
			addLast(value);
			return;
		}
		Node n = new Node(value);
		Node curr = head;
		while(index > 0) {
			curr = curr.next;
			index--;
		}
		n.next = curr;
		n.prev = curr.prev;
		curr.prev.next = n;
		curr.prev = n;
		count++;
	}
	
	void removeFirst() {
		if(head == null) {
			return;
		}
		head.next.prev = null;
		head = head.next;
		count--;
	}
	void removeLast() {
		if(head == null)return;
		
		tail.prev.next = null;
		tail = tail.prev;
		count--;
	}
	
	void removeAtIndex(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			removeFirst();
			return;
		}
		if(index == size()-1) {
			removeLast();
			return;
		}
		Node curr = head;
		while(index > 0) {
			curr = curr.next;
			index--;
		}
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
		count--;
	}
	
	boolean contains(Object key) {
		if(head == null) {
			return false;
		}
		Node curr = head;
		while(curr != null) {
			if(curr.data.equals(key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	void printForward() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data +"->");
			curr = curr.next;
		}
		System.out.println("NULL");
	}
	
	void printBackward() {
		if(tail == null) {
			System.out.println("List is empty.");
			return;
		}
		
		Node curr = tail;
		while(curr != null) {
			System.out.print(curr.data +"<-");
			curr = curr.prev;
		}
		System.out.println("NULL");
	}
	
	int size() {
		return count;
	}
	boolean isEmpty() {
		return size()==0;
	}
	public static void main(String[] args) {
		DoubleLinkedList1 dList = new DoubleLinkedList1();
		dList.printForward();
		dList.addFirst(10);
		dList.addFirst(20);
		dList.addLast(30);
		dList.addLast(40);
		dList.printForward();
		dList.addAtIndex(0, 1);
		dList.printForward();
		dList.removeFirst();
		dList.printForward();
		dList.removeLast();
		dList.printForward();
		dList.removeAtIndex(2);
		dList.printForward();
		System.out.println(dList.contains(23));

	}

}
