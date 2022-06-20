class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        num_freqs = Counter(nums)

        # nlargest takes in a number, a list (or iterable), and a key
        # the key is a function that returns what should be used to compare the elements

        # Can use a lambda, or separately define own function, or use built in function
        return heapq.nlargest(k, num_freqs, key=num_freqs.get)