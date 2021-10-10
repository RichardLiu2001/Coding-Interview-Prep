class Solution {
    public int removeElement(int[] nums, int val) {
        
    	int valsInFront = 0;
    	for (int i = 0; i < nums.length; i ++) {
    		if (nums[i] == val) {
    			valsInFront++;
    		} else {
    			nums[i - valsInFront] = nums[i];
    		}
    	}

    	return nums.length - valsInFront; 

    }

    //Suggested Solutions
    public int removeElement(int [] nums, int val) {
    	int i = 0;
    	for (int j = 0; j < nums.length; j ++) {
    		if (nums[j] != val) {
    			nums[i] = nums[j];
    			i ++;
    		}
    	}

    	return i;
    }

    // best way
    public int removeElement(int[] nums, int val) {
    	int i = 0;
    	int n = nums.length; // n is the number of elements after the vals have been removed
    	while (i < n) {
    		if (nums[i] == val) {
    			nums[i] = nums[n - 1];
    			n --;
    		} else {
    			i ++;
    		}
    	}
    	return n;
    }

}