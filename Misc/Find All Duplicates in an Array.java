class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i ++) {

            // use the SIGN of the current number's index (minus one, but 
            // you get the idea) to mark whether or not you've encountered
            // that number before

            // abs() in case it's negative
            int current_num = Math.abs(nums[i]);

            if (nums[current_num - 1] < 0) {
                // encountered this number before and marked the spot as negative
                // (prior encounter would have used the same formula)
                result.add(current_num);
            } else {
                nums[current_num - 1] *= -1;
            }
        }

        return result;

    }
}