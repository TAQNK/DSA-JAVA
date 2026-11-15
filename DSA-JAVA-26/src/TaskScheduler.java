import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {

	    PriorityQueue<Integer> maxHeap =
	        new PriorityQueue<>(Comparator.reverseOrder());

	    int[] freq = new int[26];

	    // Step 1: Calculate frequencies
	    for (char c : tasks) {
	        freq[c - 'A']++;
	    }

	    // Step 2: Build max heap
	    for (int f : freq) {
	        if (f > 0) {
	            maxHeap.offer(f);
	        }
	    }

	    // Step 3: Cooldown queue
	    Queue<int[]> queue = new ArrayDeque<>();

	    int time = 0;

	    while (!maxHeap.isEmpty() || !queue.isEmpty()) {

	        // Release tasks whose cooldown has expired
	        while (!queue.isEmpty() && queue.peek()[1] <= time) {

	            int[] task = queue.poll();

	            maxHeap.offer(task[0]);
	        }

	        // Execute the task with highest frequency
	        if (!maxHeap.isEmpty()) {

	            int remainingFreq = maxHeap.poll();

	            remainingFreq--;

	            // Put task into cooldown
	            if (remainingFreq > 0) {
	                queue.offer(new int[]{
	                    remainingFreq,
	                    time + n + 1
	                });
	            }

	            time++;
	        }

	        // If no task is available, jump to next available time
	        else if (!queue.isEmpty()) {

	            time = queue.peek()[1];
	        }
	    }

	    return time;
	}
	public static void main(String[] args) {


	}

}
