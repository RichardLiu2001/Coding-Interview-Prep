class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;
  		int[] result = new int[2];

        while (right > left) {
        	int sum = numbers[left] + numbers[right];

        	if (sum == target) {
        		result[0] = left;
        		result[1] = right;
        		return result;
        	} else if (sum < target) {
        		left ++;
        	} else {
        		right --;
        	}
        }

        return result;

    }


}