class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        low = 0

        high = len(numbers) - 1

        while low < high:

            sum = numbers[low] + numbers[high]

            if sum == target:

                return [low + 1, high + 1]

            # sum is too small, we need a bigger low
            if sum < target:

                low += 1

            # sum is too big, we need a smaller high
            else:

                high -= 1

        return []

