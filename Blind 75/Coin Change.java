class Solution {
    public int coinChange(int[] coins, int amount) {

        //HashMap<Integer, Integer> coinChange = new HashMap<>();

        //return coinChangeHelp(coins, amount, coinChange);

        return coinChangeBottomUp(coins, amount);

    }

    public int coinChangeHelpTopDown(int[] coins, int amountRemaining, HashMap<Integer, Integer> coinChange) {

        if (amountRemaining == 0) {

            return 0;
        }

        if (amountRemaining < 0) {

            return -1;
        }

        if (coinChange.containsKey(amountRemaining)) {
            return coinChange.get(amountRemaining);
        }


        int minCoins = Integer.MAX_VALUE;


        for (int coin : coins) {

            int currentCoin = coinChangeHelpTopDown(coins, amountRemaining - coin, coinChange);
            if (currentCoin >= 0) {
                minCoins = Math.min(minCoins, currentCoin + 1);
            }
            
        }

        int result = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        coinChange.put(amountRemaining, result);

        return result;

    }


    public int coinChangeBottomUp(int[] coins, int amount) {

        int[] minCoins = new int[amount + 1];

        Arrays.fill(minCoins, amount + 1);

        // it takes 0 coins to get an amount of 0
        minCoins[0] = 0;

        // populate the dp array of minimum amounts
        for (int currentAmount = 0; currentAmount <= amount; currentAmount ++) {

            // trying each coin
            for (int coin : coins) {

                if (coin <= currentAmount) {

                    minCoins[currentAmount] = Math.min(minCoins[currentAmount], minCoins[currentAmount - coin] + 1);
                }

            }

        }

        return minCoins[amount] == amount + 1 ? -1 : minCoins[amount];

    }
}