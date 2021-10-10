class Solution {
	public void duplicateZeros(int[] arr) {

		int addedZeros = 0;
		int lastElementIndex = arr.length - 1;
		for (int i = 0; i <= lastElementIndex - addedZeros; i ++) {
			if (arr[i] == 0) {

				if (i != lastElementIndex - addedZeros) {
					addedZeros ++;
				}
			} 
		}

		

		int copyIndex = arr.length - 1 - addedZeros;

		for (int i = copyIndex; i >= 0; i --) {

			int currentNum = arr[i];

			if (currentNum == 0) {
				arr[i + addedZeros] = 0;
				addedZeros --;
				arr[i + addedZeros] = 0;
			} else {
				arr[i + addedZeros] = currentNum;
			}


		}

		/*int resultIndex = arr.length - 1;

		for (int i = copyIndex; i >= 0; i --) {

			int currentNum = arr[i];
			arr[resultIndex] = currentNum;
			resultIndex --;
			if (currentNum == 0) {
				resultIndex --;
				arr[resultIndex] = 0;
			}

		}
		*/


	}
}