class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i ++) {


        	// duplicate 
        	if (i != 0 && nums[i] == nums[i - 1]) {
        		continue;
        	}

        	twoSum(result, nums, i);

        }

        return result;

    }

    public void twoSum(List<List<Integer>> result, int[] nums, int i) {
    	int low = i + 1;
        	int high = nums.length - 1;
        	int complement = 0 - nums[i];

        	while (low < high) {
        		int lowNum = nums[low];
        		int highNum = nums[high];

        		if (lowNum + highNum == complement) {
        			result.add(Arrays.asList(nums[i], lowNum, highNum));
        			while (low < high && lowNum == nums[low + 1]) {
        				low ++;
        			}

        			while (low < high && highNum == nums[high - 1]) {
        				high --;
        			}


        			low ++;

        		} else if (lowNum + highNum > complement) {
        			high --;
        		} else {
        			low ++;
        		}

        	}
    }
}