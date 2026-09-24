
public class HashSetClass {
	class Node{
		Node next;
		Object data;
		Node(Object value){
			data  = value;
			next = null;
		}
	}
	int count;
	Node a[] ;
	HashSetClass(int size) {
		a = new Node[size];
		count = 0;
	}
	boolean add(Object value) {
		int index = Math.abs(value.hashCode() % a.length);
		Node n = new Node(value);
		if(a[index] == null) {
			a[index] = n;
			count++;
			return false;
		}
		Node temp = null;
		Node curr = a[index];
		while(curr != null) {
			if(curr.data.equals(value)) {
				return false;
			}
			temp = curr;
			curr = curr.next;
		}
		temp.next = n;
		count++;
		return true;
	}
	int size() {
		return count;
	}
	void display() {
		for(int i = 0 ; i < a.length ; i++) {
			Node curr = a[i];
			while(curr != null) {
				System.out.println(curr.data);
				curr = curr.next;
			}
		}
	}
	boolean contains(Object value) {
		int index = Math.abs(value.hashCode() % a.length);
		Node curr = a[index];
		while(curr != null) {
			if(curr.data.equals(value)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	public static void main(String[] args) {
		HashSetClass hs1 = new HashSetClass(10);
		hs1.add(10);
		hs1.add(50);
		hs1.add(10);
		
		hs1.add(20);
		hs1.add(10);
		hs1.add(30);
		hs1.add(40);
		hs1.add(10);
		
		hs1.add(40);
		hs1.display();
		System.out.println(hs1.size());
		
		System.out.println("::::::::::::::::::::::::::::::::::::::");
		HashSetClass hs2 = new HashSetClass(2);
		hs2.add("tan");
		hs2.add("tan");
		
		hs2.add("san");
		
		hs2.add("psan");
		
		hs2.add("asdasdan");
		
		hs2.add("sdadastan");
		hs2.add("sdasdn");
		hs2.display();
		

	}

}
