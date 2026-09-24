
public class QueueUsingArray {
	Object[] a ;
	int size;
	int rear ;
	int front;
	
	QueueUsingArray(int i){
		a = new Object[i];
		rear = -1;
		front = 0;
		size = i;
	}
	boolean isEmpty() {
		return rear == -1;
	}
	boolean isFull() {
		return rear == size-1;
	}
	// enqueue O(1)
	void add(Object value) {
		if(rear == size-1) {
			System.out.println("Sorry queue is full.");
			return ;
		}
		a[++rear] = value;
		size++;
		return;
	}
	// dequeue O(n)
	Object remove() {
		if(rear == -1) {
			System.out.println("Nothing to remove.Queue is empty.");
			return -1;
		}
		// shifting of elements to front
		Object key = a[front];
		for(int i = 0 ; i < rear ; i++) {
			a[i] = a[i+1];
		}
		rear--;
		return key;
	}
	// front
	Object peek() {
		if(rear == -1) {
			System.out.println("Nothing to show.Queue us empty.");
			return -1;
		}
		return a[front];
	}
	void display() {
		if(rear == -1) {
			System.out.println("Enter elements first.Queue is empty.");
			return;
		}
		for(int i = front ; i <= rear ; i++) {
			System.out.print(a[i]+"|");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		QueueUsingArray q1 = new QueueUsingArray(5);
		q1.add(10);
		q1.add(20);
		q1.add(30);
		q1.display();
		q1.remove();
		q1.display();
		System.out.println(q1.peek());
		
	}

}
