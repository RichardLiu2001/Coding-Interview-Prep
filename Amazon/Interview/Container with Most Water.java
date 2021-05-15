class Solution {

    public int maxArea(int[] height) {

    	// brute force: try all containers

    	/*
    	int maxArea = 0;

    	for (int i = 0; i < height.length; i ++) {
    		for (int j = i + 1; j < height.length; j ++) {

    			int currentArea = getArea(i, j,j - i);

    			maxArea = Math.max(maxArea, currentArea);

    		}
    	}
    	return maxArea;
    	*/

    	if (height == null || height.length < 2) {
    		return -1;
    	}

    	int maxArea = 0;

    	int left = 0;
    	int right = height.length - 1;

    	while (left < right) {

    		int currentArea = getArea(height[left], height[right], right - left);

    		maxArea = Math.max(maxArea, currentArea);
    		if (height[left] < height[right]) {
    			left ++;
    		} else {
    			right --;
    		}

    	}

    	return maxArea;

	}



    public int getArea(int left, int right, int base) {
    	return Math.min(left, right) * base;
    }


}	