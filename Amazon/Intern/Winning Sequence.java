class Solution {

public static int[] winningSequence(int num, int lower, int upper) {
	

	int[] result = new int[num];

	int delta = upper - lower;

	if (num > 2 * delta + 1) {
		return null;
	}

	int starting_num = upper - 1;

	while (upper - starting_num + 1 + delta < num) {
		starting_num --;
	} 

	int i = 0;

	while (starting_num < upper) {
		res[i++] = starting_num ++;
 	}

 	res[i++] = starting_number --;

 	while (i < num) {
 		res[i++] = starting_number --;
 	}

 	return res; 






}





}

