class Solution {

	// keep a hashmap of all the integers and their indices, and check if current num's index is k away
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
    	HashMap<Integer, Integer> indices = new HashMap<>();

    	for (int i = 0; i < nums.length; i ++) {

    		int current = nums[i];

    		if (indices.containsKey(current) && i - indices.get(current) <= k) {
    			return true;
    		}

    		indices.put(current, i);
    	}
    	return false;
    }


    // keep track of the last K elements in a hashset, and check if current number is in the set

    public boolean containsNearbyDuplicate(int[] nums, int k) {

    	HashSet<Integer> lastK = new HashSet<>();

    	for (int i = 0; i < nums.length; i ++) {
    		int current = nums[i];
    		if (lastK.contains(current)) {
    			return true;
    		}

    		lastK.add(current);

    		if (i >= k) {
    			lastK.remove(nums[i-k]);
    		}

    	}
    	return false;

    }


}