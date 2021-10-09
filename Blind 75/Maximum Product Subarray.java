class Solution {
    public int maxProduct(int[] nums) {
        
        if (nums.length < 1) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i ++) {

            int current = nums[i];

            int oldMax = maxSoFar;

            maxSoFar = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));

            minSoFar = Math.min(current, Math.min(oldMax * current, minSoFar * current));

            maxProduct = Math.max(maxProduct, maxSoFar);
        }



        return maxProduct;

    }
}