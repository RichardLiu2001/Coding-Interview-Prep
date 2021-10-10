class Solution {

	public static int search(int[] nums, int target) {
        
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) { 

			int middleIndex = (left + right) / 2;
			int middleVal = nums[middleIndex];

			if (middleVal == target) {
				return middleIndex;
			} else if (target < middleVal) {
				right = middleIndex - 1;
			} else {
				left = middleIndex + 1;
			}
		}
		return -1;

	}
}