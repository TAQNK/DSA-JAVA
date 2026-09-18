
public class ArrayListClass {
	Object [] obj = new Object[10];
	int count = 0;
	
	public  void add(Object o) {
		if(count == obj.length)
			increase();
		obj[count++] = o;
	}
	public void increase() {
		Object o = new Object[obj.length + 5];
		for(int i = 0 ; i < )
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
