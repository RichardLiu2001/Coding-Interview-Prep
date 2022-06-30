def trap(height) -> int:
    
    highest_to_left = [0 for _ in range(len(height))]
    highest_to_right = [0 for _ in range(len(height))]
    
    highest_to_left[0] = height[0]
    highest_to_right[-1] = height[-1]
    
    for i in range(1, len(height)):

        previous_wall_height = height[i - 1]
        
        highest_to_left[i] = max(previous_wall_height, highest_to_left[i - 1])


    for i in range(len(height) - 2, -1, -1):

        previous_wall_height = height[i - 1]

        highest_to_right[i] = max(previous_wall_height, highest_to_right[i + 1])

    print(height)       
    print(highest_to_left)
    print(highest_to_right)

    total_trapped_water = 0

    for i in range(1, len(height) - 1):

        current_wall_height = height[i]
        
        left_highest_height = highest_to_left[i]
        right_highest_height = highest_to_right[i]
        
        if left_highest_height > current_wall_height and right_highest_height > current_wall_height:

            current_index_trapped_water = min(left_highest_height, right_highest_height) - current_wall_height

            total_trapped_water += current_index_trapped_water
    
    
    return total_trapped_water

height = [0,1,0,2,1,0,1,3,2,1,2,1]

print(trap(height))

    