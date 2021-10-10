class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashSet<Integer> nums = new HashSet<>();

        for (int currentNum : arr) {
        	if (nums.contains(currentNum * 2)) {
        		return true;
        	} 
        	if (currentNum % 2 == 0) {
        		if (nums.contains(currentNum / 2)) {
        			return true;
        		}

        	}
        	nums.put(currentNum); // put at end, in case the current num is 0. If we put first then checked, 
        	// it will return true if currentNum is 0 because 0 is it's own double/half. 
        }
        return false; 

    }
}