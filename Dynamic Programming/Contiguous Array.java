class Solution {
    public int findMaxLength(int[] nums) {
        
        int maxLength = 0;

        // 0 indicates -1, 1 indicates + 1
        // store running sum in hashmap
        int runningSum = 0;

        HashMap<Integer, Integer> runningSums = new HashMap<>();

        // runningSums.put(0, -1)

        for (int i = 0; i < nums.length; i ++) {


            int currentNum = nums[i];

            if (currentNum == 0) {
                runningSum --;
            } else {
                runningSum ++;
            }


            // contiguous subarray from the beginning to i has an equal number of 0's and 1's 
            // if runningSum is 0

            // also, contiguous subarray from a previous index to i has an equal number of 
            // 0's and 1's if runningSum already exists (stored in hashmap)

            // noneed if put (0, -1) initially
            if (runningSum == 0) {
                maxLength = i + 1;
            } else if (runningSums.containsKey(runningSum)) {

                maxLength = Math.max(maxLength, i - runningSums.get(runningSum));
            } else {
                runningSums.put(runningSum, i);
            }

        }

        return maxLength;

    }
}