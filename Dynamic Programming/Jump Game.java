class Solution {
    public boolean canJump(int[] nums) {
        
        // search all paths from current index

        // store failures so that, if we encounter a path that we've gone through before
        // (and failed), we can just skip it.

        boolean[] paths = new boolean[nums.length];
        Arrays.fill(paths, true);

        return canJumpFromIndex(nums, paths, 0);

    }

    public boolean canJumpFromIndex(int[] nums, boolean[] paths, int startIndex) {

        if (startIndex == nums.length - 1) {
            return true;
        }

        // out of bounds
        if (startIndex >= nums.length) {

            return false;
        }

        // check memoization, if we've been here before (and failed)
        if (!paths[startIndex]) {
            return false;
        }


        int currentNum = nums[startIndex];

        // trying all jump lengths

        for (int i = 1; i <= currentNum; i ++) {
            if (canJumpFromIndex(nums, paths, startIndex + i)) {
                return true;
            }

        }

        // none of the jumps worked :(
        paths[startIndex] = false;
        return false;

    }
}