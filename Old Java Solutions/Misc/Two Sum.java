class Solution {
   public int[] twoSum(int[] nums, int target) {
		
   		int[] result = new int[2];

   		HashMap<Integer, Integer> seenAlready = new HashMap<>();

   		for (int i = 0; i < nums.length; i ++) {

   			int current = nums[i];
   			int complement = target - current; 

   			if (seenAlready.containsKey(complement)) {
   				result[0] = seenAlready.get(complement);
   				result[1] = i;
   				return result;
   			}

   			seenAlready.put(current, i);

   		}

   		return result;

    }
}