
public class StackUsingArray {
	Object[] o ;
	int top;
	int count = 1;
	StackUsingArray(int size){
		if(size < 0) {
			throw new IndexOutOfBoundsException();
		}
		o = new Object[size];
		top= -1; 
		count=0;
	}
	int size() {
		return count;
	}
	void push(Object obj) {
		if(size() == o.length) {
			System.out.println("List is full");
			return;
		}
		o[++top] = obj;
		count++;
	}
	Object pop() {
		if(count == 0) {
			throw new IndexOutOfBoundsException();
		}
		count--;
		return o[top--];
	}
	Object peek() {
		if(count == 0) {
			throw new IndexOutOfBoundsException();
		}
		return o[top];
	}
	boolean isEmpty() {
		return count==0;
	}
	public static void main(String[] args) {
		StackUsingArray s = new StackUsingArray(5);
		s.push(10);
		s.push(20);
		s.push(30);
		while(!s.isEmpty()) {
			System.out.println(s.peek());
			s.pop();
		}
	}

}
