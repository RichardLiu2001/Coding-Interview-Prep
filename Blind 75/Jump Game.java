class Solution {
    public boolean canJump(int[] nums) {
        
        //boolean[] alreadyFailed = new boolean[nums.length];

        return canJumpGreedy(nums);

    }

    public boolean canJumpFromIndexTopDown(int currentIndex, int[] nums, boolean[] alreadyFailed) {

        if (alreadyFailed[currentIndex]) {
            return false;
        }

        int currentNum = nums[currentIndex];


        // check if you can reach the end from this index, using this jump length
        if (currentNum + currentIndex >= nums.length - 1) {
            return true;
        }

        // trying all possible jump lengths
        for (int i = 1; i <= currentNum; i ++) {

            if (canJumpFromIndexTopDown(currentIndex + i, nums, alreadyFailed)) {
                return true;
            }
        }

        alreadyFailed[currentIndex] = true;

        return false;

    }

    public boolean canJumpBottomUp(int[] nums) { 

        boolean[] canJumpToEndFromIndex = new boolean[nums.length];

        // you can jump to the last index from the last index itself 
        canJumpToEndFromIndex[nums.length - 1] = true;

        for (int currentIndex = nums.length - 2; currentIndex >= 0; currentIndex --) {

            int farthestJump = Math.min(currentIndex + nums[currentIndex], nums.length - 1);

            for (int currentJump = currentIndex + 1; currentJump <= farthestJump; currentJump ++) {
                if (canJumpToEndFromIndex[currentJump]) {

                    canJumpToEndFromIndex[currentIndex] = true;

                    // if there is a single jump length from which the current index jump and make it to the end, then
                    // the current index is good, and we do not have to check any more jump lengths.
                    break;
                }
            }

        }

        return canJumpToEndFromIndex[0];

    }

    public boolean canJumpGreedy(int[] nums) {

        // if you can get to this index, then you can get to the end
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i --) {

            if (i + nums[i] >= goal) {
                goal = i;
            }

        }

        return goal == 0;

    }

}