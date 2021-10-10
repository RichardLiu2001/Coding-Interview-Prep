class Solution {
    public int thirdMax(int[] nums) {
        
    	Set<Integer> numbers = new HashSet<>();

    	for (int num : nums) {
    		numbers.add(num);
    	}

    	if (numbers.size() < 3) {
    		return Collections.max(numbers);
    	}

    	numbers.remove(Collections.max(numbers));
    	numbers.remove(Collections.max(numbers));
    	return Collections.max(numbers);
    }

}
