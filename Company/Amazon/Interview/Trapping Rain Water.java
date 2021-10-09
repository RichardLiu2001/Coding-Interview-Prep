class Solution {
    public int trap(int[] height) {
 		
 		if (height == null || height.length < 3) {
 			return 0;
 		} 

 		int n = height.length;

 		int[] leftMax = new int[n];
 		
 		leftMax[0] = height[0];

 		for (int i = 1; i < n; i ++) {
            // not sure why height[i], wouldn't it include the current height?
            // I think including current height is ok, for there to be water trapped 
            // the max has to be greater than the current height.
 			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
 		}

 		int[] rightMax = new int[n];

 		rightMax[n - 1] = height[n - 1];

 		for (int i = n - 2; i >= 0; i --) {
 			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
 		}

 		int result = 0;



    	for (int i = 1; i < n; i ++) {
    		int rMax = rightMax[i];
    		int lMax = leftMax[i];

    		result += Math.min(rMax, lMax) - height[i];

    		//result += getWaterAbove(height, i);
    	}

    	return result;

    }

    // brute force
    public int getWaterAbove(int[] height, int i) {

    	int rightMax = height[i];
    	int leftMax = height[i];

    	for (int j = i - 1; j >= 0; j --) {
    		leftMax = Math.max(leftMax, height[j]);
    	}

    	for (int j = i + 1; j < height.length; j ++) {
    		rightMax = Math.max(rightMax, height[j]);
    	}

    	return Math.min(rightMax, leftMax) - height[i];

    }




}