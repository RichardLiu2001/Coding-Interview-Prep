class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
        	numbers.put(nums[i], i);
        	int difference = target - nums[i];
        	// problem: if the number plus itself is the target, it will use that number twice. 
        	if (numbers.containsKey(difference)) {
        		int differenceIndex = numbers.get(difference);
        		result[0] = Math.min(i, differenceIndex);
        		result[1] = Math.max(i, differenceIndex);
        		return result;
        	}
        }
        return result;
    }

    // brute force, try all possible combinations
    public int[] twoSumBruteForce(int[] nums, int target) {
    	int[] result = new int[2];
    	for (int i = 0; i < nums.length; i ++) {
    		for (int j = i + 1; j < nums.length; j ++) {
    			if (nums[i] + nums[j] == target) {
    				result[0] = i;
    				result[1] = j;
    				return result;
    			}
    		}
    	}
    	return result; 
    }
}