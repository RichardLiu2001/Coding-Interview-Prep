class Solution {

	public int findNumbers(int[] nums) {

		int result = 0;
		for (int num : nums) {
			if (numOfDigits(num) % 2 == 0) {
				result ++;
			}
		}
		return result;

	}

	public int numOfDigits(int num) {

		int digits = 0;

		while (num > 0) {
			num /= 10;
			digits ++;
		}

		return digits;


	}
}