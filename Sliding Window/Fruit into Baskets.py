class Solution:

    def totalFruit(self, fruits: List[int]) -> int:
        # reframe question as "what is the longest contiguous subarray that has at most 2 distinct elements?"

        window_start = 0

        longest = 0

        fruit_freqs = {}

        for window_end in range(len(fruits)):

            current_fruit = fruits[window_end]

            if current_fruit not in fruit_freqs:
                fruit_freqs[current_fruit] = 0

            fruit_freqs[current_fruit] += 1


            while len(fruit_freqs) > 2:

                window_start_fruit = fruits[window_start]

                fruit_freqs[window_start_fruit] -= 1
                
                if fruit_freqs[window_start_fruit] == 0:

                    del(fruit_freqs[window_start_fruit])
                
                window_start += 1
                
            longest = max(longest, window_end - window_start + 1)
            
        
        return longest