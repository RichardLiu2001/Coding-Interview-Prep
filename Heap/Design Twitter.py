class Twitter:

    def __init__(self):
        self.time = 0 # use smaller (negative) values for recent to make default minheap easier to use
        self.tweetMap = defaultdict(list) # userId -> list of (time, tweetId)
        # we append to the end of tweet map for every tweet, thus it is already sorted by time

        self.followingMap = defaultdict(set) # followerId -> set of followees (people who they are following)


    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append((self.time, tweetId))
        self.time -= 1


    def getNewsFeed(self, userId: int) -> List[int]:
        result = []
        minHeap = []

        # news feed includes own tweets, add self to followees
        # will only keep 1 copy since followees is a set
        self.followingMap[userId].add(userId)

        for followeeId in self.followingMap[userId]:

            followee_tweet_list = self.tweetMap[followeeId]
            most_recent_tweet_index = len(followee_tweet_list) - 1
            most_recent_tweet_id = followee_tweet_list[most_recent_tweet_index]
            tweet_time = self.tweetMap[most_recent_tweet_id]


    def follow(self, followerId: int, followeeId: int) -> None:
        self.followingMap[followerId].append(followeeId)


    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followingMap[followerId]:
            self.followingMap[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)