class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        if (nums.length < 1) {
        	return false;
        }

        int[] runningSum = new int[nums.length];
       	runningSum[0] = nums[0];

        for (int i = 1; i < runningSum.length; i ++) {
        	runningSum[i] = runningSum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i ++) {
        	for (int j = i + 1; j < nums.length; j ++) {

        		if (divisible(runningSum, nums, k, i, j)) {
        			return true;
        		}

        	}
        }

        return false;

    }

    public boolean divisible(int[] runningSum, int[] nums, int k, int start, int finish) {

    	int sum = runningSum[finish] - runningSum[start] + nums[start];
        
        if (k == 0) {
            return sum == 0;
        }
 
    	return sum % k == 0;

    }
}