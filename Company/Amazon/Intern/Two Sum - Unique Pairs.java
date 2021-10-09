class Solution {

	// find how many unique pairs in the array such that their sum is equal to target
	public int uniquePairs(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();

		// pairs that work
		Set<Integer> seen = new HashSet<>();

		int count = 0;

		for (int num : nums) {
			if (set.contains(target-num) && !seen.contains(num)) {
				count ++;
				seen.add(target-num);
				seen.add(num);
			} else if (!set.contains(num)) {
				set.add(num);
			}
		}

		return count;
	}




}