class Solution:
    
    def permute(self, nums: List[int]) -> List[List[int]]:

        result = []

        self.backtrack(nums, 0, result)

        return result

    def backtrack(self, nums, first, result):

        if first == len(nums):
            result.append(nums[:])

        for i in range(first, len(nums)):

            nums[first], nums[i] = nums[i], nums[first]

            self.backtrack(nums, first + 1, result)

            nums[first], nums[i] = nums[i], nums[first]


    def permuteNeetcode(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 0:
            return [[]]

        if len(nums) == 1:
            return [[nums[0]]]

        result = []

        for i in range(len(nums)):

            front = nums.pop(0)

            permutations = self.permute(nums)

            for permutation in permutations:

                permutation.append(front)
                #permutation.insert(0, front)

            result.extend(permutations)
            
            nums.append(front)
            #nums.insert(0, front)


        return result



