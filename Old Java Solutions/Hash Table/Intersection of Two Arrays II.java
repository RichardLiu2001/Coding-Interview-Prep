class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
    	if (nums2.length < nums1.length) {
    		return intersect(nums2, nums1);
    	}

    	/// hashmap mapping each integer in nums1 to its frequency

    	HashMap<Integer, Integer> nums = new HashMap<>();

    	for (int num : nums1) {

    		if (!nums.containsKey(num)) {

    			nums.put(num, 1);
    		} else {
    			int freq = nums.get(num);
    			nums.put(num, freq + 1);
    		}
    	}

    	ArrayList<Integer> list = new ArrayList<>();

    	for (int num : nums2) {

    		if (nums.containsKey(num)) {
    			int freq = nums.get(num);
    			if (freq > 0) {
    				list.add(num);
    				nums.put(num, freq - 1);
    			}
    		}
    	}

    	int[] result = new int[list.size()];

    	for (int i = 0; i < list.size(); i ++) {
    		result[i] = list.get(i);
    	}
    	return result;


    }
}