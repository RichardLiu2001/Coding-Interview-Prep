class Solution {
    public int lengthOfLIS(int[] nums) {

    	if (nums.length == 0 || nums.length == 1) {
    		return nums.length;
    	}

    	return lengthHelp(nums, 0, Integer.MIN_VALUE, 0);
   	}

   	public int lengthHelp(int[] nums, int index, int currentLargest, int lengthSoFar) {

   		if (index >= nums.length) {
   			return lengthSoFar;
   		}

   		int currentVal = nums[index];

   		if (currentVal > currentLargest) {
   			// choice: use this currentVal or don't use it. 
   			// return the max of either

   			return Math.max(lengthHelp(nums, index + 1, currentVal, lengthSoFar + 1), lengthHelp(nums, index + 1, currentLargest, lengthSoFar));

   		}

   		return lengthHelp(nums, index + 1, currentLargest, lengthSoFar);

   	}

}