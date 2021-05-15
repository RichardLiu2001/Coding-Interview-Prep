class Solution {
    public int pivotIndex(int[] nums) {
        
        if (nums.length == 0) {
        	return -1;
        }

        if (nums.length == 1) {
        	return 0;
        }

    	int totalSum = 0;
    	for (int i = 0; i < nums.length; i ++) {
    		totalSum += nums[i];
    	}

    	int leftSum = 0;
    	for (int i = 0; i < nums.length; i ++) {
    		int currentPivot = nums[i];

    		int rightSum = totalSum - currentPivot - leftSum;

    		if (rightSum == leftSum) {
    			return i;
    		}

    		leftSum += currentPivot; 
    	}

    	return -1;

    }
}