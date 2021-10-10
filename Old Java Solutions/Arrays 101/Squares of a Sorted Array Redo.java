class Solution {
	public int[] sortedSquares(int[] A) {
		int[] result = new int[A.length];

		int left = 0;
		int right = A.length - 1;
		int resultIndex = A.length - 1;

		while (left <= right) {
 
			int rightSquared = A[right] * A[right];
			int leftSquared = A[left] * A[left];

			if (rightSquared > leftSquared) {
				result[resultIndex] = rightSquared;
				right --;

			} else {

				result[resultIndex] = leftSquared;
				left ++;
			}
			resultIndex --;
		}

		return result; 


	}
}