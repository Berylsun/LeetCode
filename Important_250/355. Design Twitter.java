class Twitter {
    public int timeStamp;
    public HashMap<Integer,User> map;
    
    class Tweet {
        public int id;
        public Tweet next;
        public int time;
        public Tweet (int id) {
            this.id = id;
            next = null;
            time = timeStamp++;
        }
    }
    
    class User {
        public int id;
        public Tweet tweetHead;
        public HashSet<Integer> followed;
        
        public User(int id) {
            this.id = id;
            tweetHead = null;
            followed = new HashSet<>();
            follow(id);
        }
        
        public void follow(int id) {
            followed.add(id);
        }
        
        public void unFollow(int id) {
            followed.remove(id);
        }
        
        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }
    
       
    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = 0;
        map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!map.containsKey(userId)) return res;
        HashSet<Integer> users = map.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        for (int user : users) {
            if (map.get(user).tweetHead != null) {
                pq.offer(map.get(user).tweetHead);
            }            
        }
        
        while (!pq.isEmpty()) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (res.size() == 10) {
                break;
            }
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User(followerId));
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User(followeeId));
        }
        map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        map.get(followerId).unFollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
