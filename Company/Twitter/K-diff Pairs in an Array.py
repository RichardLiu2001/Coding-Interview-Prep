class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        result = 0

        freqs = {}

        for num in nums:
            oldFreq = 0
            if num in freqs:
                oldFreq = freqs[num]

            freqs[num] = oldFreq + 1


        for num in freqs:
            if k > 0 and num + k in freqs:
                result += 1

            elif k == 0 and freqs[num] > 1:
                result += 1

        return result