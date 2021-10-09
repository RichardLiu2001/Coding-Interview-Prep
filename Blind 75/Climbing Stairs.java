class Solution {
    public int climbStairs(int n) {
        
        //int[] dp = new int[n + 1];
        //Arrays.fill(dp, -1);

        //return climbStairsTopDown(n, dp);
        //return climbStairsBottomUp(n);
        return fibonacci(n);
    }

    public int climbStairsTopDown(int n, int[] dp) {

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int oneStepDown = climbStairsTopDown(n - 1, dp);
        int twoStepsDown = climbStairsTopDown(n - 2, dp);

        // dp[n - 1] = oneStepDown;

        //if (n > 1) {
        //    dp[n - 2] = twoStepsDown;
        // }

        dp[n] = oneStepDown + twoStepsDown;

        return oneStepDown + twoStepsDown;

    }

    public int climbStairsBottomUp(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i ++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    public int fibonacci(int n) {

        int prev = 1;
        int prevPrev = 1;

        for (int i = 2; i <= n; i ++) {

            int sum = prev + prevPrev;
            prevPrev = prev;
            prev = sum;
        }

        return prev;

    }

}