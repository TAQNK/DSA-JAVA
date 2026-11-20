import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HandsInStraight {
	public static boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0)
			return false;

		Map<Integer, Integer> count = new HashMap<>();

		for (int n : hand) {
			count.merge(n, 1, Integer::sum);
		}

		PriorityQueue<Integer> minH = new PriorityQueue<>(count.keySet());

		while (!minH.isEmpty()) {
			int first = minH.peek();
			for (int i = first; i < first + groupSize; i++) {
				if (!count.containsKey(i)) {
					return false;
				}
				count.put(i, count.get(i) - 1);

				if (count.get(i) == 0) {
					if (minH.peek() != i) {
						return false;
					}
					minH.poll();
				}

			}
		}
		return true;
	}

	public static boolean secondIntuation(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0)
			return false;

		Map<Integer, Integer> count = new HashMap<>();

		for (int num : hand) {
			count.merge(num, 1, Integer::sum);
		}

		for (int num : hand) {
			int start = num;

			while (count.getOrDefault(start - 1, 0) > 0)
				start--;

			while (start <= num) {
				while (count.getOrDefault(start, 0) > 0) {
					for (int i = start; i < start + groupSize; i++) {

						if (count.getOrDefault(i, 0) == 0)
							return false;
						count.put(i, count.get(i) - 1);
					}
				}
				
				start++;
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(secondIntuation(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));

	}

}
