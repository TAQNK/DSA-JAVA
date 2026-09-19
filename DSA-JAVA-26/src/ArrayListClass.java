
public class ArrayListClass {
	Object [] obj = new Object[10];
	int count = 0;
	
	public  void add(Object o) {
		if(count == obj.length)
			increase();
		obj[count++] = o;
	}
	public void increase() {
		Object [] o = new Object[obj.length + 5];
		for(int i = 0 ; i < size() ; i++) {
			o[i] = obj[i];
		}
		obj = o;
	}
	public int size() {
		 return count;
	}
	public boolean isEmpty() {
		return count==0;
	}
	public void addAtIndex(Object ele , int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		// right shift from last index and till index
		for(int i = size() - 1 ; i >= index ; i-- ) {
			obj[i+1] = obj[i];
		}
		obj[index] = ele;
		count++;
	}
	
	public void removeIndex(int index) {
		if(index < 0 || index  >= size()) {
			throw new IndexOutOfBoundsException();
		}
		// left shift from index + 1 till last index
		for(int i = index ; i <= size() ; i++) {
			obj[i] = obj[i+1];
		}
	}
	
	public void setIndex(Object ele , int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		obj[index] = ele;
	}
	public Object getIndex(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		return obj[index];
	}
	public void print() {
		if(count == 0) {
			System.out.println("Empty List.");
			return;
		}
		for(int i = 0 ;i  <size() ; i++) {
			System.out.print(obj[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListClass a = new ArrayListClass();
		a.add(19);
		a.addAtIndex(20, 1);
		a.print();
	}

}
