class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // first filling in with cumulative left product

        int cumLeftProduct = 1;

        for (int i = 0; i < nums.length; i ++) {

            result[i] = cumLeftProduct;
            cumLeftProduct *= nums[i];

        }

        int cumRightProduct = 1;

        for (int i = nums.length - 1; i >= 0; i --) {

            result[i] = result[i] * cumRightProduct;
            cumRightProduct *= nums[i];

        }

        return result;
    }
}