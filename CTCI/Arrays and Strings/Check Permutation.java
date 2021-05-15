class Solution {

	public static boolean checkPermutation(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false; 
		}

		final int ASCII_VALUES = 128;
		int[] s1Chars = new int[ASCII_VALUES];
		int[] s2Chars = new int[ASCII_VALUES];

		for (int i = 0; i < s1.length(); i ++) {
			char s1Char = s1.charAt(i);
			char s2Char = s2.charAt(i);
			s1Chars[(int) s1Char] ++;
			s2Chars[(int) s2Char] ++;

		}

		for (int i = 0; i < ASCII_VALUES; i ++) {
			if (s1Chars[i] != s2Chars[i]) {
				return false;
			}
		}
		return true; 


	}


}