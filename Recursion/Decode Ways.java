class Solution {

	public static int numDecodings(String s) {
		int[] memo = new int[s.length()];

		for (int i = 0; i < memo.length; i ++) {
			memo[i] = -1;
		}

		return decodeHelp(s, 0, memo);
	}

	public static int decodeHelp(String s, int index, int[] memo) {
		if (index == s.length()) {
			return 1;
		}
        
        if (s.charAt(index) == '0') {
			return 0;
		}

		if (memo[index] != -1) {
			return memo[index];
		}

		int result = decodeHelp(s, index + 1, memo);

		if (index < s.length() - 1) {
			int nextNum = Integer.parseInt(s.substring(index, index + 2));
			if (nextNum <= 26) {
				result += decodeHelp(s, index + 2, memo);
			}
		}

		memo[index] = result;

		return result;

	}
}