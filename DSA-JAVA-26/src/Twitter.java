import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {


    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{count, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--;
    }
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new ArrayList<>();
		PriorityQueue<int[]>minHeap = new PriorityQueue<>(
				(a , b) ->Integer.compare(a[0], b[0])
				);
		
//		follow himself for getting his own tweets
		followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
		
//		two conditions if user follows less than 10 people and one for following more than 10
		
		if(followMap.get(userId).size() >= 10) {
			
//			if greater than 10
			
			PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
					(a,b) -> Integer.compare(a[0], b[0]));
			
//			start traversing over the follower list
			
			for(int followeeId : followMap.get(userId)) {
//				if they dont tweet then skip them
				if(tweetMap.containsKey(followeeId) == false)continue;
				
//				if exist fetch those tweets
				List<int[]> tweets = tweetMap.get(followeeId);
				int index = tweets.size() -1;
				int[] tweet = tweets.get(index);
//				storing the last  tweet from that followee in maxheap with negative count as they the recent ones have more negative and they appear at last not at top(older ones).
				maxHeap.offer(new int[] {-tweet[0] , tweet[1] , followeeId , index - 1});
				
				if(maxHeap.size() > 10) {
//					remove older
					maxHeap.poll();
				}
			}
			
//			now the top recent 10 tweets added to min heap
			while(!maxHeap.isEmpty()) {
				int[] tweet = maxHeap.poll();
//				again the negative is converted to positive as older will be at last
				minHeap.offer(new int[] {-tweet[0] , tweet[1] , tweet[2] , tweet[3]});
			}
		}else {
			for(int followeeId : followMap.get(userId)) {
				
				if(!tweetMap.containsKey(followeeId))continue;
				List<int[]> tweets=  tweetMap.get(followeeId);
				int index = tweets.size() - 1;
				int[] tweet = tweets.get(index);
				
				minHeap.offer(new int[] {tweet[0] , tweet[1] , followeeId , index - 1});
				
			}
		}
		
//		k - merging 
		
		while(!minHeap.isEmpty() && res.size() <= 10) {
			
			int[] topTweet = minHeap.poll();
			res.add(topTweet[1]);
			
			int nextIndex = topTweet[3];
			if(nextIndex >= 0) {
				List<int[]>tweets = tweetMap.get(topTweet[2]);
				int[] nextTweet = tweets.get(nextIndex);
				minHeap.offer(new int[] {nextTweet[0] , nextTweet[1] , topTweet[2] , nextIndex - 1 });
			}
		}
		
		
		return res;
	}

	  public void follow(int followerId, int followeeId) {
	        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
	    }

	    public void unfollow(int followerId, int followeeId) {
	        if (followMap.containsKey(followerId)) {
	            followMap.get(followerId).remove(followeeId);
	        }
	    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */