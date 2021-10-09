class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //dp[0] = 1;

        for (int i = 1; i < dp.length; i ++) {

            int currentNum = nums[i];

            for (int j = 0; j < i; j ++) {

                int currentLongestIncreasingSubsequence = dp[j];
                int currentLongestIncreasingSubsequenceBiggestNumber = nums[j];

                if (currentNum > currentLongestIncreasingSubsequenceBiggestNumber) {
                    dp[i] = Math.max(currentLongestIncreasingSubsequence + 1, dp[i]);
                }
            }
        }

        int max = 0;

        for (int num : dp) {
            max = Math.max(max, num);
        }

        return max;

    }
}