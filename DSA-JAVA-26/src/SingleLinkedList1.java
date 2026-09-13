
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
	public static void main(String[] args) {
		SingleLinkedList1 List = new SingleLinkedList1();
		// adding elements
		List.add(10);
		List.add(10);
		List.add(20);
		List.add(10);
		List.add(10);
		List.print();
		// removing element
		List.remove();
		List.remove();
		List.remove();
		List.print();
		// size of list
		List.size();
		// searching a object
		List.search(20);
		List.search(10);
		
		
		
		

	}

}
