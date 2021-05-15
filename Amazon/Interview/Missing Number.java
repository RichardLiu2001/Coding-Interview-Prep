class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }

        for (int i = 0; i <= nums.length; i ++) {
        	if (!numbers.contains(i)) {
        		return i;
        	}
        }

        return -1;
    }
}