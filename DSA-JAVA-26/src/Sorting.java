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
	
	
	public static void MergeSort(int[] arr , int low , int high) {
		if (low >= high)return ; // only single element left nothing is there to divide 
		
		int mid = (low + high) / 2 ;
		// dividing the array into a bigger and smaller or two equal portions
		MergeSort( arr , low , mid );// left half portion
		MergeSort( arr , mid + 1 , high);
		// after division is completed i have to merge the sorted arrays
		Merge( arr , low , mid , high);
	}
	private static void Merge(int[] arr, int low, int mid, int high) {
		
		// so i have two arrays 
		// Left array (low , mid) and Right array (mid +1 , high)
		// start a pointer in left and a pointer in right 
		int left = low , right = mid + 1;
		int[] temp = new int[high - low + 1];
		int i =0 ;
		
		while(left <= mid && right <= high) {
			
			if(arr[left] <= arr[right]) {
				temp[i ++] = arr[left ++];
			}
			else {
				temp[i ++] = arr[right ++];
			}
			
		}
		
		// element left in any of the array has to be added 
		while(left <= mid) {
			
			temp[i ++] = arr[left ++];
			
		}
		while(right <= high) {
			
			temp[i ++] = arr[right ++];
			
		}
		
		// Transferring the sorted elements in the original array
		for(int j = low ; j <= high ; j++) {
			arr[j] = temp[j - low];
		}
		
	}

	
	// quick sort
	public static void QuickSort(int[] a , int low , int high) {
		
		if(low < high) {
			int partitionIndex = partitionFunction(a , low , high);
			QuickSort(a , low , partitionIndex - 1);
			QuickSort(a , partitionIndex + 1 , high);
		}
		
		
	}
	private static int partitionFunction(int[] a, int low, int high) {
		
		int pivot = low ; 
		int i = low + 1;
		int j = high;
		
		while(i <= j) {
			while(i <= high && a[i] <= a[pivot]){
				i++;
			}
			
			while(j > low && a[j] > a[pivot]) {
				j--;
			}
			
			if(i < j)swap(a , i , j);
		}
		
		swap(a, pivot , j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int [] arr = new int[] {7,5,4,3,1,2,9,4,5,12,12,6};

System.out.println(Arrays.toString(selectionSort(new int[]{3,13,45,62,3,5,6})));
System.out.println(Arrays.toString(bubbleSort(new int[]{3,13,45,62,3,5,6})));
System.out.println(Arrays.toString(insertionSort(new int[]{3,13,45,62,3,5,6})));

QuickSort(arr , 0 , arr.length - 1);
System.out.println(Arrays.toString(arr));

	}

}
