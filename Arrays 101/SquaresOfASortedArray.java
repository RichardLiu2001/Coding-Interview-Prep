class Solution {

	// Naive O(N log N )
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i ++) {
        	result[i] = A[i] * A[i];
        }

        Arrays.sort(result);
        return result;
    }

    // Efficient O(N)
    public int[] sortedSquares(int[] A) {
    	int[] result = new int[A.length];
    	int leftIndex = 0;
    	int rightIndex = A.length - 1;

    	for (int i = result.length - 1; i >= 0; i --) {
    		int leftNum = A[leftIndex] * A[leftIndex];
    		int rightNum = A[rightIndex] * A[rightIndex];

    		if (leftNum >= rightNum) {
    			result[i] = leftNum;
    			leftIndex ++;
    		} else {
    			result[i] = rightNum;
    			rightIndex --;
    		}

    	}
    	return result;

    }
}