class Solution {

    public static int change(int amount, int[] coins) {
        return help(amount, 0, 0, coins);
    }

    public static int help(int amount, int currentAmount, int index, int[] coins) {

        if (currentAmount == amount) {
            return 1;
        }

        if (currentAmount > amount || index >= coins.length) {
            return 0;
        }

        return help(amount, currentAmount, index + 1, coins) + help(amount, currentAmount + coins[index], index, coins);

    }
}
