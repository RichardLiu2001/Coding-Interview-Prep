class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        num_set = set(nums)

        max_streak_length = 0

        # iterate over num_set, nums could have duplicates that we don't need to try
        for num in num_set:

            # we have already found a sequence that will contain the current num, so we don't need to 
            # try the current num
            if num - 1 in num_set:
                continue

            current_num = num
            current_streak = 0

            while current_num in num_set:
                current_streak += 1
                current_num += 1
            
            max_streak_length = max(max_streak_length, current_streak)

        return max_streak_length