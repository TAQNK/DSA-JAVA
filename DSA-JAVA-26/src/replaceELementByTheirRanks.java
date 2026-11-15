import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class replaceELementByTheirRanks {
	public List<Integer> replaceWithRank(List<Integer> arr) {
		// Your code goes here
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Integer num : arr) {
			pq.offer(num);
		}

		Map<Integer, Integer> mp = new HashMap<>();
		int rank = 1;
		while (!pq.isEmpty()) {
			int num = pq.poll();
			if (!mp.containsKey(num)) {
				mp.put(num, rank++);
			}
		}
		List<Integer> ranks = new ArrayList<>();
		for (Integer n : arr) {
			ranks.add(mp.get(n));
		}
		return ranks;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
