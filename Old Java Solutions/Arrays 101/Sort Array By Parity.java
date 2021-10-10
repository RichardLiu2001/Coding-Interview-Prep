class Solution {
	public int[] sortArrayByParity(int[] A) {

		for (int i = 0; i < A.length; i ++) {

			if (A[i] % 2 != 0) {

				int firstEvenIndex = i + 1;
				boolean found = false;
				while (!found && firstEvenIndex < A.length) {
					if (A[firstEvenIndex] % 2 == 0) {
						found = true;
						int temp = A[i];
						A[i] = A[firstEvenIndex];
						A[firstEvenIndex] = temp;
					} 

					firstEvenIndex ++;
				}

			}

		}

		return A;

	}
}