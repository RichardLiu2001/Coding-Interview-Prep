class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        max_area = 0

        left = 0
        right = len(height) - 1

        while left < right:

            container_length = right - left 
            left_wall_height = height[left]
            right_wall_height = height[right]

            container_area = container_length * min(left_wall_height, right_wall_height)

            max_area = max(max_area, container_area)
            
            # Container area is limited by whichever is smaller of the two sides - even if we find a taller 
            # wall for the side that is already taller, the area won't change since the water can still
            # only go up to the shorter wall, which is the same.
            # Thus, we move inwards whichever wall is shorter to try to find a taller wall.
            if left_wall_height < right_wall_height:

                left += 1
            
            else:

                right -=1 
            
        return max_area
