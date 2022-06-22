class Solution:

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # frequencies of each number
        num_freqs = Counter(nums)

        # list of buckets (lists) - index i holds the list of numbers that occur i times
        freq_buckets = [[] for i in range(len(nums) + 1)]

        for num in num_freqs:

            num_freq = num_freqs[num]

            freq_buckets[num_freq].append(num)

        result = []
        
        # get elements in reverse order of buckets (from greatest to least frequency)
        for i in range(len(freq_buckets) - 1, 0, -1):

            current_freq_bucket = freq_buckets[i]

            for num in current_freq_bucket:

                result.append(num)

                if len(result) == k:

                    return result

        return result
        

    def topKFrequentHeap(self, nums: List[int], k: int) -> List[int]:
        
        num_freqs = Counter(nums)

        # nlargest takes in a number, a list (or iterable), and a key
        # the key is a function that returns what should be used to compare the elements

        # Can use a lambda, or separately define own function, or use built in function
        return heapq.nlargest(k, num_freqs, key=num_freqs.get)