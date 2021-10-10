class Solution {
    public void moveZeroesWithCopy(int[] nums) {
        int[] copy = new int[nums.length];
        int copyZeroIndex = nums.length - 1;
        int copyIndex = 0;
        for (int i = 0; i < nums.length; i ++) {
        	if (nums[i] == 0) {
        		copy[copyZeroIndex] = 0;
        		copyZeroIndex --;
        	} else {
        		copy[copyIndex] = nums[i];
        		copyIndex ++;
        	}
        }
        nums = copy;
    }

    public void moveZeroes(int[] nums) {
    	int nonZeroIndex = 0;
    	for (int i = 0; i < nums.length; i ++) {
    		if (nums[i] != 0) {
    			nums[nonZeroIndex] = nums[i];
    			nonZeroIndex ++;
    		}
    	}
    	for (int i = nonZeroIndex; i < nums.length; i ++) {
    		nums[i] = 0;
    	}
    }

}