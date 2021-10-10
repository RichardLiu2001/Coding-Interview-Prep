class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxConsecutive = 0;
        int currentConsecutive = 0;

        for (int num : nums) {

            if (num == 1) {
                currentConsecutive ++;
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);

            } else {
                // maxConsecutive = Math.max(maxConsecutive, currentConsecutive);

                currentConsecutive = 0;
            }

        }

        return maxConsecutive;

        // return Math.max(maxConsecutive, currentConsecutive);
    }
}