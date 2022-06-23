class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        # left_products[i] = the product of all numbers to the left of index i (not including i)
        # idea is to multiply all numbers to the left of i with all numbers to the right of i and have the 
        # left and right products already precalculated
        left_products = [1 for i in range(len(nums))]

        # skip index 0, there is nothing to the left of it
        for i in range(1, len(nums)):

            left_products[i] = left_products[i - 1] * nums[i - 1]


        #right_product = [1 for i in range(len(nums))]

        #for i in range(len(nums) - 1, -1, -1):

        #    if i == len(nums) - 1:
        #        continue

        #    right_product[i] = right_product[i + 1] * nums[i + 1]

ß

        # we can just store the single cumulative right product instead of all right products, because we use each
        # value just once
        cumulative_right_product = 1

        for i in range(len(left_products) - 1, -1, -1):

            if i != len(nums) - 1:

                cumulative_right_product *= nums[i + 1]

            # reuse left_products for result since it already stores the left products, and we no longer need 
            # them after we calculate the product
            left_products[i] = left_products[i] * cumulative_right_product

        return left_products
