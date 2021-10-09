class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums.length < 2) {
            return null;
        }

        int[] result = new int[2];

        // map seen nums to their indices
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            
            int current = nums[i];

            int complement = target - current;

            if (seen.containsKey(complement)) {
                result[0] = seen.get(complement);
                result[1] = i;
                return result;
            }

            seen.put(current, i);
        }

        return result;

    }
}