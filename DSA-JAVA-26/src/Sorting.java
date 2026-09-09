// Sorting ALgo - Selection
import java.util.Arrays;
public class Sorting {
	public static int[] selectionSort(int[]a) {
		
		for(int i = 0 ; i < a.length - 1 ; i++) {
			
			int min = i ;
			
			for(int j = i + 1 ; j < a.length ; j++) {
				if(a[min] > a[j]) {
					min = j ;
				}
			}
			
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		return a;
	}
	
	public static int[] bubbleSort(int[] a) {
		
		for(int i = a.length - 1 ; i >= 1 ; i --) {
			
			for(int j = 0 ; j <= i - 1 ; j++) {
				
				if(a[j] > a[j+1]) {
					
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				
				}
			}
		}
		
		return a;
	}
	public static int[] insertionSort(int[] a) {
		
		for(int i = 1 ; i < a.length ; i++) {
			
			int j = i;
			
			while(a[j-1] > a[j]) {
				
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
				
			}
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub



System.out.println(Arrays.toString(selectionSort(new int[]{3,13,45,62,3,5,6})));
System.out.println(Arrays.toString(bubbleSort(new int[]{3,13,45,62,3,5,6})));
System.out.println(Arrays.toString(insertionSort(new int[]{3,13,45,62,3,5,6})));
	}

}
