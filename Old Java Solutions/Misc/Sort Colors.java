class Solution {
    public void sortColors(int[] nums) {
        
        for (int i = 0; i < nums.length; i ++) {
        	int current = nums[i];
        	if (current == 0) {
        		bubbleUp(i, nums);
        	} else if (current == 2) {
        		bubbleDown(i, nums);
        	}
        }
    }

    public void bubbleDown(int index, int[] nums) {

    	while (index < nums.length - 1) {
    		int temp = nums[index];
    		nums[index] = nums[index + 1];
    		nums[index + 1] = temp;
    	}

    }

    public void bubbleUp(int index, int[] nums) {

    	while (index > 0) {
    		int temp = nums[index];
    		nums[index] = nums[index - 1];
    		nums[index - 1] = temp;
    	}
    }

    public void sortColors(int[] nums) {
    	int zero = 0;
    	int one = 0;
    	int two = 0;

    	for (int i = 0; i < nums.length; i ++) {
    		int current = nums[i];
    		if (current == 0) {
    			zero ++;
    		} else if (current == 1) {
    			one ++;
    		} else {
    			two ++;
    		}
    	}

    	for (int i = 0; i < nums.length; i ++) {
    		if (zero > 0) {
    			nums[i] = 0;
    			zero --;
    		} else if (one > 0) {
    			nums[i] = 1;
    			one --;
    		} else {
    			nums[i] = 2;
    		}
    	}
    }













    }
}