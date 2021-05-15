class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxCounter = 0;
        int currentCounter = 0;
        for (int currentNum : nums) {

        	if (currentNum == 1) {
        		currentCounter ++;
        		maxCounter = Math.max(currentCounter, maxCounter);
        	} else {
        		currentCounter = 0;
        	}
        }
        return maxCounter; 
    }
}