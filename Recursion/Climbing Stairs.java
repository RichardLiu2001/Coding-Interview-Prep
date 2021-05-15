class Solution {
    public int climbStairs(int n) {
        
        int[] memo = new int[n];
        for (int i = 0; i < memo.length; i ++) {
        	memo[i] = -1;
        }

    	return climbStairsHelp(n, 0, memo);

    }

    public int climbStairsHelp(int n, int current, int[] memo) {

    	if (current == n) {
    		return 1;
    	}

    	if (current > n) {
    		return 0;
    	}

    	if (memo[current] != -1) {
    		return memo[current];
    	}

    	int result = climbStairsHelp(n, current + 1, memo) + climbStairsHelp(n, current + 2, memo);
    	memo[current] = result;
    	return result;

    }

}