class Solution {
	public int[] sortedSquares(int[] A) {

		int right = A.length - 1;
		int left = 0;

		int[] result = new int[A.length];
		int resultIndex = result.length - 1;

    	while (left <= right) { // !!! <=, < will result in one element being skipped. 
    		int leftSquare = A[left] * A[left];
    		int rightSquare = A[right] * A[right];

    		if (leftSquare > rightSquare) {
    			result[resultIndex] = leftSquare;
    			left ++;
    		} else {
    			result[resultIndex] = rightSquare;
    			right --;
    		}
    		resultIndex --;
    	}
    	return result;

    }

    // Solution
    public int[] sortedSquares(int[] A) {
    	int N = A.length;
    	int j = 0;
    	while (j < N && A[j] < 0) {
    		j ++;
    	}
    	int i = j - 1;
    	// i is the index of the last negative number
    	// j is the index of the first positive number

    	int[] ans = new int[N];
    	int t = 0;

    	while (i >= 0 && j < N) {
    		if (A[i] * A[i] < A[j] * A[j]) {
    			ans[t++] = A[i] * A[i];
    			i --;
    		} else {
    			ans[t++] = A[j] * A[j];
    			j ++;
    		}
    	}

    	// fill in the leftovers from either side
    	while (i >= 0) {
    		ans[t++] = A[i] * A[i];
    	}

    	while (j < N) {
    		ans[t++] = A[j] * A[j];

    		
    	}
    	return ans;
    }

}