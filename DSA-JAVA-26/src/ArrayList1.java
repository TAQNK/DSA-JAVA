import java.util.ArrayList;
import java.util.List;
public class ArrayList1 {

	public static void main(String[] args) {
		
		// creating a arrayList
		List<Integer> l1 = new ArrayList<>();
		// also we can use 
		ArrayList<Integer> l2 = new ArrayList<>();
		// note we an create arraylist of primitive data types as generics dont allow them
		
		// operations we can perform :
		
		// adding elements 
		l1.add(10);// direct value/ element added in my arrayList l1- [10]
		l1.add(1,20); // based on the index i can also add the elements  l1 - [10 , 20]
//		l1.add(4 ,1002); out of bound exception the 3rd index value is not yet initialized
		
		// get the elements using the index value as they folw insertion order 
		System.out.println(l1.get(0));
		System.out.println(l1.get(1));
//		System.out.println(l1.get(2)); out of bounds exception 
		
		// modify / setting the value of elements to different values
		l1.set(0, null);// arraylist allows duplicates as well as the nulls
		System.out.println(l1.get(0));// prints null instead of providing null pointer exception
		
		// remove the elements 
		l1.remove(1);// based on index i can remove elements 
		l1.add(10);
		l1.add(200);
		l1.remove(Integer.valueOf(10));// based on the values but allows only objects 
		// Traversal using traditional for
		for(int i = 0 ; i < l1.size() ; i++)System.out.println(l1.get(i));
		
		//searching a element 
		System.out.println(l1.contains(200));
		
		// index of elements also the last index index you can also find 
		System.out.println(l1.indexOf(200) + " "+ l1.lastIndexOf(200));
		
		// size () - to the number of elements stored in my arraylist
		System.out.println(l1.size());
		
		// clearing the whole array
		l1.clear();
		
		// checking weather the arrayList is empty or not 
		System.out.println(l1.isEmpty());
		
	}

}
