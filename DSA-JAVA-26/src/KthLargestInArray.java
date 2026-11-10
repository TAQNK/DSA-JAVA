
public class KthLargestInArray {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int n, int i) {

        while (true) {
            int maximum = i;

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[left] > arr[maximum]) {
                maximum = left;
            }

            if (right < n && arr[right] > arr[maximum]) {
                maximum = right;
            }

            if (maximum == i) {
                break;
            }

            swap(arr, i, maximum);
            i = maximum;
        }
    }

    public static int findKthLargest(int[] arr, int k) {

        int n = arr.length;

        // Build Max Heap
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract maximum k-1 times
        for (int i = 0; i < k - 1; i++) {
            arr[0] = arr[n - 1];
            n--;

            heapify(arr, n, 0);
        }

        return arr[0];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};

        System.out.println(findKthLargest(arr, 2));
    }
}
