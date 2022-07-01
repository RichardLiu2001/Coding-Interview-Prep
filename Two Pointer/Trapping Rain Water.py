class Solution:
    # two pointer O(N) time O(1) space solution
    def trap(self, height: List[int]) -> int:

        left = 0
        right = len(height) - 1
        left_max = 0
        right_max = 0

        total_trapped_water = 0
        
        # must be <= since we process and then move the index
        while left <= right:
            
            # we choose which side to process from based on whichever max is 
            # smaller, since that side will be the bottleneck. In addition,
            # since we started the left and right pointers at the beginning and 
            # end of the array respectively, the corresponding direction max height
            # (left_max for left and right_max for right) is guaranteed to be correct.
            if left_max < right_max:

                current_height = height[left]
                
                # although we don't know the true height of the right_max wall,
                # it doesn't matter since the left_max wall is already shorter
                # than what we currently have for right_max

                # the current trapped water is bottlenecked by the left_max wall,
                # which is the shorter of the two max walls
                current_trapped_water = left_max - current_height

                # If the current wall is taller than both right and left max,
                # no water can be trapped.
                if current_trapped_water > 0:
                    total_trapped_water += current_trapped_water
                
                left_max = max(left_max, current_height)
                left += 1

            else:

                current_height = height[right]

                current_trapped_water = right_max - current_height
    
                if current_trapped_water > 0:
                    total_trapped_water += current_trapped_water
                
                right_max = max(right_max, current_height)
                right -= 1

        return total_trapped_water

    # DP O(N) time O(N) space solution
    def trapDP(self, height: List[int]) -> int:

        highest_to_left = [0 for _ in range(len(height))]
        highest_to_right = [0 for _ in range(len(height))]

        # populate highest_to_left
        for i in range(1, len(height)):

            previous_wall_height = height[i - 1]

            highest_to_left[i] = max(previous_wall_height, highest_to_left[i - 1])

        # populate highest_to_right
        for i in range(len(height) - 2, -1, -1):

            previous_wall_height = height[i + 1]

            highest_to_right[i] = max(previous_wall_height, highest_to_right[i + 1])

        total_trapped_water = 0

        # skip first and last block, they cannot trap any water since they're on the edge
        for i in range(1, len(height) - 1):

            current_wall_height = height[i]

            left_highest_height = highest_to_left[i]
            right_highest_height = highest_to_right[i]

            if left_highest_height > current_wall_height and right_highest_height > current_wall_height:

                current_index_trapped_water = min(left_highest_height, right_highest_height) - current_wall_height
                total_trapped_water += current_index_trapped_water

        return total_trapped_water

    