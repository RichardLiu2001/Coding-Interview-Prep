class Solution {

	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;

		int maxArea = 0;

		while (left < right) {

			int leftHeight = height[left];
			int rightHeight = height[right];

			int currentArea = getArea(leftHeight, rightHeight, right - left);
			maxArea = Math.max(maxArea, currentArea);

			if (leftHeight < rightHeight) {
				left ++;
			} else {
				right --;
			}
		}

		return maxArea;


	}



    public int maxArea(int[] height) {
        
    	int maxArea = 0;

    	for (int i = 0; i < height.length; i ++) {

    		int leftHeight = height[i];

    		for (int j = i + 1; j < height.length; j ++) {

    			int rightHeight = height[j];
    			int currentArea = getArea(leftHeight, rightHeight, j - i);
    			maxArea = Math.max(maxArea, currentArea);
    		}


    	}

    	return maxArea;



    }

    public int getArea(int left, int right, int base) {
    	return Math.min(left, right) * base;
    }


}