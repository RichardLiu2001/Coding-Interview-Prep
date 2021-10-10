class Solution {
    public int removeDuplicates(int[] nums) {
        
        int oldNum = nums[0];

    	int actualIndex = 0;
    	for (int i = 0; i < nums.length; i ++) {
    		int currentNum = nums[i];

    		if (currentNum != oldNum) {
    			actualIndex ++;
    			nums[actualIndex] = currentNum;
    			oldNum = currentNum;
    		}

    	}

    	return actualIndex;

    }

    public int removeDuplicates2(int[] nums) {

        int index = 1;
        for (int i = 1; i < nums.length; i ++) {

            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index ++;
            }
        }
        return index;
    }
}