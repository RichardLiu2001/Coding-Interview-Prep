class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int currentAmount = 0; currentAmount <= amount; currentAmount ++) {

        	for (int coin = 0; coin < coins.length; coin ++) {

        		int coinVal = coins[coin];
        		if (currentAmount >= coinVal) {
        			dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coinVal]);
        		} else {
        			break;
        		}

        	}

        }



    }
}