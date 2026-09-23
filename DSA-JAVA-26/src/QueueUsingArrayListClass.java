import java.util.ArrayList;
import java.util.List;

public class QueueUsingArrayListClass {
	private List<Object> queue ;
	
	// add is just same as arrayList add
	void add(Object data) {
		queue.add(data);
	}
	Object poll() {
		if(queue.isEmpty()) {
			throw new NullPointerException();
		}
		return queue.removeFirst();
	}
	int size() {
		return queue.size();
	}
	boolean isEmpty() {
		return queue.isEmpty();
	}
	Object peek() {
		if(queue.isEmpty()) {
			throw new NullPointerException();
		}
		return queue.get(0);
	}
	QueueUsingArrayListClass(){
		queue = new ArrayList<>();
	}
	public static void main(String[] args) {
		QueueUsingArrayListClass q = new QueueUsingArrayListClass();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}

	}

}
