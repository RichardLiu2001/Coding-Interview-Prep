class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        //int[] combos = new int[target + 1];
        //Arrays.fill(combos, -1);

        //return combinationHelp(nums, target, combos);
        return combinationBottomUp(nums, target);

    }

    public int combinationHelp(int[] nums, int target, int[] combos) {

        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        if (combos[target] != -1) {
            return combos[target];
        } 

        int total = 0;

        for (int i = 0; i < nums.length; i ++) {
            int currentCombinations = combinationHelp(nums, target - nums[i], combos);
            total += currentCombinations;
        }

        combos[target] = total;

        return total;
    }

    public int combinationBottomUp(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i ++) {

            for (int num : nums) {

                int subProblem = i - num;
                if (subProblem >= 0) {
                    dp[i] += dp[subProblem];
                }

            }

        }

        return dp[target];

    }
}


