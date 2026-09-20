
public class CircularSinglyLinkedList {
	Node head;
	int count;
	class Node{
		Node next;
		Object data;
		
		Node(Object value){
			data = value;
			next = null;
		}
	}
	CircularSinglyLinkedList(){
		head = null;
		count = 0;
	}
	void addFirst(Object value) {
		Node n = new Node(value);
		if(head == null) {
			head = n;
			n.next = n;
			count++;
			return;
		}
		Node curr = head;
		while(curr.next != head) {
			curr = curr.next;
		}
		curr.next = n;
		n.next = head;
		head = n;
		count++;
	}
	void addLast(Object value) {
		Node n = new Node(value);
		if(head == null) {
			head = n;
			n.next = n;
			count++;
			return;
		}
		Node curr = head;
		while(curr.next != head) {
			curr = curr.next;
		}
		curr.next = n;
		n.next = head;
		count++;
	}
	void addAtIndex(int index , Object value) {
		if(index < 0 || index > size() ) {
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
		Node n = new Node(value);
		while(index - 1 > 0) {
			index --;
			curr = curr.next;
		}
		n.next = curr.next;
		curr.next = n;
		count++;
	}
	void removeFirst() {
		if(head == null) {
			throw new IndexOutOfBoundsException();
		}
		if(head.next == head) {
			head = null;
			count--;
			return;
		}

		// make the last node point to new head
		Node curr = head;
		while(curr.next != head) {
			curr = curr.next;
		}
		curr.next = head.next;
		head = head.next;
		count--;
		
	}
	void removeLast() {
		if(head == null) {
			throw new IndexOutOfBoundsException();
		}
		if(head == head.next) {
			head = null;
			count--;
			return;
		}
		Node curr = head;
		while(curr.next.next != head) {
			curr = curr.next;
		}
		curr.next = head;
		count--;
	}
	void removeAtIndex(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if(head == null) {
			return;
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
		while(index - 1 > 0) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
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
			return false;
		}
		Node curr = head;
		while(curr.next != head) {
			if(curr.data.equals(value)) {
				return true;
			}
			curr = curr.next;
		}
		if(curr.data.equals(value)) {
			return true;
		}
		return false;
	}
	void print() {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		if(head.next == head) {
			System.out.println(head.data);
			return;
		}
		Node curr = head;
		while(curr.next != head) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.print(curr.data+"\n");
	}
	
	public static void main(String[] args) {
		CircularSinglyLinkedList cList = new CircularSinglyLinkedList();
		cList.addFirst(10);
//		cList.removeFirst();
		cList.addFirst(10);
//		cList.addFirst(10);
		cList.addLast(20);
//		cList.print();
//		cList.addAtIndex(4,  30);
//		cList.removeLast();
		cList.print();
//		System.out.println(cList.contains(50));
		cList.removeAtIndex(1);
		cList.print();
	}

}
