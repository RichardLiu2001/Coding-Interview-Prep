class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int minDiff = Integer.MAX_VALUE;    
        int resultSum = -1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                int currentDiff = target - sum;

                if (Math.abs(currentDiff) < Math.abs(minDiff)) {
                    minDiff = currentDiff;
                    resultSum = sum;
                }

                if (sum < target) {
                    low ++;
                } else {
                    high --;
                }
            }


        }

        return resultSum;


    }

}