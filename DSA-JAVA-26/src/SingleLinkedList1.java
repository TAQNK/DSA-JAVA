
public class SingleLinkedList1 {
	private Node head ; 
	private int size ;
	SingleLinkedList1(){
		head = null;
		size = 0;
	}
	private class Node {
		Object value;
		Node next;
		Node(Object data){
			value = data;
			next = null;
		}
	}
	
	public void add(Object value) {
		Node n = new Node(value);
		
		if(head == null) {
			head = n;
			System.out.println(head.value+" element is added.");
			size++;
			return;
		}
		
		Node currnode = head;
		while(currnode.next != null) {
			currnode = currnode.next ;
		}
		System.out.println(n.value+" element is added.");
		currnode.next = n;
		size++;
	}
	public void print() {
		if(head == null) {
			System.out.println("List is empty.");
			return ;
		}
		Node currnode = head;
		while(currnode != null) {
			System.out.print(currnode.value +"->");
			currnode = currnode.next;
		}
		System.out.println("NULL");
	}
	public void remove() {
		if(head == null) {
			System.out.println("List is empty.");
			return ;
		}
		
		// 1 element is present 
		if(head.next == null) {
			System.out.println(head.value+" element is removed.");
			head= null;
			size--;
			return;
		}
		Node currnode = head;
		while(currnode.next.next != null) {
			currnode = currnode.next ;
		}
		System.out.println(currnode.next.value+" element is removed.");
		currnode.next = null;
		size--;
		
	}
	
	public void size() {
		System.out.println("Size of list : " +size);
		
	}
	
	public void search(Object v) {
		if(head == null) {
			System.out.println("List is empty.");
			return;
		}
		Node currNode = head;
		int i = 0;
		while(currNode.next != null) {
			if(currNode.value == v) {
				System.out.println(v+" is present at index "+i+".");
				return ;
			}
			i++;
			currNode = currNode.next;
		}
		System.out.println(v+" is not present inside your list.");
		
		
	}
	
	// reversing a linked list
	public  void ReverseIterate() {
		// 3 pointer approach 
		// if list contains 1 or no elements 
		if(head == null || head.next == null) return;
		Node prevNode = head ;
		Node  currNode = head.next;
		while(currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode ;
			//update the pointers
			prevNode = currNode ;
			currNode = nextNode ;
		}
		head.next = null;
		head = prevNode;
	}
	
	// using recursion
	public Node ReverseRecursion(Node head) {
		// consider stack having different linked list and will be returning a already reversed list
		if(head == null || head.next == null)return head;
		Node nextHead = ReverseRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return nextHead;
		
	}
	public static void main(String[] args) {
		SingleLinkedList1 List = new SingleLinkedList1();
		// adding elements
		List.add(60);
		List.add(40);
		List.add(20);
		List.add(10);
		List.add(30);
		List.print();
		// removing element
		List.remove();
		List.remove();
		List.print();
		// size of list
		List.size();
		// searching a object
		List.search(20);
		List.search(10);
		List.ReverseIterate();
		List.print();
		List.head = List.ReverseRecursion(List.head);
		List.print();
		
		
		

	}

}
