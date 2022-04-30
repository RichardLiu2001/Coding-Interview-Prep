class Solution:
    
    def permute(self, nums: List[int]) -> List[List[int]]:

        result = []

        #self.backtrack(nums, 0, result)

        used = [False for _ in range(len(nums))]

        self.buildPermutations(nums, [], used, result)

        #self.swapPermutations(nums, 0, result)

        return result


    def buildPermutations(self, nums, currentPermutation, used, result):

        if len(currentPermutation) == len(nums):

            result.append(currentPermutation[:])

        else:

            for i in range(len(nums)):

                if not used[i]:

                    currentPermutation.append(nums[i])
                    used[i] = True
                    self.buildPermutations(nums, currentPermutation, used, result)

                    used[i] = False
                    currentPermutation.pop()


    def swapPermutations(self, nums, currentIndex, result):

        if currentIndex == len(nums):

            result.append(nums[:])

        else:

            for i in range(currentIndex, len(nums)):

                nums[i], nums  [currentIndex] = nums[currentIndex], nums[i]

                self.swapPermutations(nums, currentIndex + 1, result)

                nums[i], nums  [currentIndex] = nums[currentIndex], nums[i]



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

            result.extend(permutations)
            
            nums.append(front)


        return result