class Twitter:

    def __init__(self):
        self.time = 0 # use smaller (negative) values for recent to make default minheap easier to use
        self.tweetMap = defaultdict(list) # userId -> list of (time, tweetId)
        # we append to the end of tweet map for every tweet, thus it is already sorted by time

        self.followingMap = defaultdict(set) # followerId -> set of followees (people who they are following)

        # Note about defaultdict: defaultdict[NONEXISTENT_KEY] returns the default value (an empty list, set, etc.)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append((self.time, tweetId))
        self.time -= 1


    def getNewsFeed(self, userId: int) -> List[int]:
        result = []

        minHeap = [] # stores tweets that could potentially appear in the feed in chronological order

        # news feed includes own tweets, add self to followees
        # will only keep 1 copy since followees is a set
        self.followingMap[userId].add(userId)

        # add the most recent tweet of all followees
        for followeeId in self.followingMap[userId]:

            if followeeId in self.tweetMap:

                followee_tweet_list = self.tweetMap[followeeId]
                most_recent_tweet_index = len(followee_tweet_list) - 1
                most_recent_tweet_time, most_recent_tweet_id = followee_tweet_list[most_recent_tweet_index]

                heapq.heappush(minHeap, (most_recent_tweet_time, most_recent_tweet_id, followeeId, most_recent_tweet_index))

        # the heap now contains the most recent tweet of every followee. 
        # we will pop the most recent tweet, add it to the result, and 
        # add the next most recent tweet of that followee to the heap.

        # this guarantees the correct chronological order of tweets because 
        # tweets are added to the heap (and thus inserted in time order) regardless 
        # of the followee. 

        # The next most recent tweet will always be processed next because either:
        # a) it is already the next element in the heap
        # b) it is the child (same parent followee) of the current element, which will add it and move it to the front

        # Note: the next most recent tweet cannot be the child of a different followee than the current
        # tweet because the parent tweet (which is more recent) must already exist in the heap.
        # This is because we added all the "most recent" parents earlier.
        while len(minHeap) > 0 and len(result) < 10:

            # get the information of the most recent tweet that should appear in the user's feed
            most_recent_tweet_time, most_recent_tweet_id, followeeId, most_recent_tweet_index = heapq.heappop(minHeap)
            result.append(most_recent_tweet_id)

            # find the next most recent tweet from that followee
            next_most_recent_tweet_index = most_recent_tweet_index - 1

            if next_most_recent_tweet_index >= 0:
                time, tweetId = self.tweetMap[followeeId][next_most_recent_tweet_index]

                heapq.heappush(minHeap, (time, tweetId, followeeId, next_most_recent_tweet_index))

        return result


    def follow(self, followerId: int, followeeId: int) -> None:
        self.followingMap[followerId].add(followeeId)


    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followingMap[followerId]:
            self.followingMap[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)