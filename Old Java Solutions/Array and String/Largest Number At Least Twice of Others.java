class Solution {
    public int dominantIndex(int[] nums) {
        
    	if (nums.length == 1) {
    		return 0;
    	}

    	int dominantIndex = 0;

    	int largest = -1;
    	int secondLargest = -1;

    	for (int i = 0; i < nums.length; i ++) {

    		int current = nums[i];

    		if (current > largest) {
    			secondLargest = largest;
    			largest = current;
    			dominantIndex = i;

    		} else if (current > secondLargest) {
    			secondLargest = current;
    		}

    	}

    	return largest >= 2 * secondLargest ? dominantIndex : -1;


    }
}