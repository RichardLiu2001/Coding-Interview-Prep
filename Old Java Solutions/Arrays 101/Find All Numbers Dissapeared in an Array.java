class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i ++) {

        	int currentNum = Math.abs(nums[i]) - 1;
        	if (nums[currentNum] > 0) {
        		nums[currentNum] *= -1;
        	}

        }

        for (int i = 0; i < nums.length; i ++) {
        	if (nums[i] > 0) {
        		result.add(i + 1);
        	}
        }

        return result;

    }
}