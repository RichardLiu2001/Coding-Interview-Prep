class Solution {
    public int findNumbers(int[] nums) {
        
        int result = 0;
        for (int currentNum : nums) {

        	int digits = (currentNum + "").length();
        	if (digits % 2 == 0) {
        		result ++;
        	}

        }
        return result;
    }

    public int findNumbers(int[] nums) {
    	int result = 0;

    	for (int currentNum : nums) {

    		int digits = getDigits(currentNum);
    		if (digits % 2 == 0) {
    			result ++;
    		}
    	}
    	return result;
    }

    public int getDigits(int currentNum) {
    	int result = 0;
    	while (currentNum > 0) {
    		result ++;
    		currentNum /= 10;
    	}
    	return result;
    }
}