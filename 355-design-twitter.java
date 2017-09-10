// Design a simplified version of Twitter where users can post tweets,
// follow/unfollow another user and is able to see the 10 most recent
// tweets in the user's news feed. Your design should support the following
// methods:

// postTweet(userId, tweetId): Compose a new tweet.
// getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news
//                      feed. Each item in the news feed must be posted by users
//                      who the user followed or by the user herself. Tweets must
//                      be ordered from most recent to least recent.
// follow(followerId, followeeId): Follower follows a followee.
// unfollow(followerId, followeeId): Follower unfollows a followee.

// Solution: https://discuss.leetcode.com/topic/48100/java-oo-design-with-most-efficient-function-getnewsfeed/12
class Twitter {

  /** Initialize your data structure here. */
  public Twitter() {

  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {

  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {

  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {

  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {

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
