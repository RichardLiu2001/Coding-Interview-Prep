class Solution {
    public int[] productExceptSelf(int[] nums) {
            
        int n = nums.length;

        //int[] rightProduct = new int[n];
        int[] leftProduct = new int[n];


        // filling leftProduct
        leftProduct[0] = 1;
        for (int i = 1; i < n; i ++) {

            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;

        for (int i = leftProduct.length - 1; i >= 0; i --) {

            leftProduct[i] = leftProduct[i] * rightProduct;

            rightProduct *= nums[i];

        }

        return leftProduct;


        /*
        // filling rightProduct

        rightProduct[n - 1] = 1;

        for (int i = n - 2; i >= 0; i --) {

            rightProduct[i] = rightProduct[i + 1] * nums[i + 1]; 

        }

        int[] result = new int[n];

        for (int i = 0; i < n; i ++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
        */

    }
}