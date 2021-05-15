class Solution {

	public static boolean isPermutationOfPalindrome(String s) {

		String processed = s.toLowerCase.replace(" ", "");

		boolean evenLength = processed.length() % 2 == 0;

		char[] freqs = new char[128];

		for (int i = 0; i < processed.length(); i ++) {
			char current = processed.charAt(i);
			freqs[(int) current] ++;
		}

		int oddFreqs = 0; 

		for (int i = 0; i < 128; i ++) {
			if (freqs[i] % 2 == 1) {
				oddFreqs ++;
			}
		}

		if (evenLength) {
			return oddFreqs == 0;
		} else {
			return oddFreqs == 1;
		}

	}
	


}