// when implementing queue using array this is preferred as the circular queue takes O(1) for add , remove and peek operation.
public class CircularQueueUsingArray {
	Object[] a ;
	int size;
	int rear ;
	int front;
	
	CircularQueueUsingArray(int i){
		a = new Object[i];
		rear = -1;
		front = -1;
		size = i;
	}
	boolean isEmpty() {
		return rear == -1 && front == -1;
	}
	boolean isFull() {
		return (rear+1)%size == front;
	}
	// enqueue O(1)
	void add(Object value) {
		if(isFull()) {
			System.out.println("Sorry queue is full.");
			return ;
		}
		if(front == -1) {
			front ++;
		}
		rear = (rear +1)%size;
		a[rear] = value;
		return;
	}
	// dequeue O(1)
	Object remove() {
		if(isEmpty()) {
			System.out.println("Nothing to remove.Queue is empty.");
			return -1;
		}
		Object key = a[front];
		if(rear == front) {
			rear = front = -1;
		}else {
			front = (front+1)%size;
		}
		return key;
	}
	// front
	Object peek() {
		if(isEmpty()) {
			System.out.println("Nothing to show.Queue us empty.");
			return -1;
		}
		return a[front];
	}
	
	public static void main(String[] args) {
		CircularQueueUsingArray q1 =new CircularQueueUsingArray(5);
		q1.add(10);
		q1.add(20);
		q1.add(30);
		while(!q1.isEmpty()) {
			System.out.print(q1.remove()+"|");
		}
		System.out.println();

	}

}
