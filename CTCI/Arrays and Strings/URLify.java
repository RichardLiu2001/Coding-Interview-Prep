class Solution {
	public static URLify(char[] chars, int trueLength) {

		int spaces = 0;

		for (int i = 0; i < trueLength; i ++) {
			char current = chars.charAt(i);
			if (current == ' ') {
				spaces ++;
			}
		}

		int index = trueLength + spaces * 2 - 1;

		for (int i = trueLength - 1; i >= 0; i --) {
			char current = chars.charAt(i);

			if (current == ' ') {
				chars[index] = '0';
				chars[index - 1] = '2';
				chars[index - 2] = '%';
				index -= 2;
			} else {
				chars[index] = current;
			}
			index --;
		}
	}
}