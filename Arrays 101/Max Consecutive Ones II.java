class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int result = 0;
        for (int i = 0; i < nums.length; i ++) {
        	result = Math.max(result, findMaxFromHere(nums, i));
        }
        return result; 
    }

    public int findMaxFromHere(int[] nums, int index) {
    	int result = 0;
    	boolean change = false; 
    	while (index < nums.length) {
    		if (nums[index] == 0) {
    			if (change) {
    				return result;
    			} else {
    				change = true;
    			}
    		}
    		result ++;
    		index ++;
    	}

    	return result; 
    }
}