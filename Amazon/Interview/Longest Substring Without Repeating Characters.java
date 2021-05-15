class Solution {

	public int lengthOfLongestSubstring(String s) {
		
		if (s.length() < 2) {
			return s.length();
		}

		// two pointers: start and end of substring
		// store the letters of the current substring in a hashset
		// try to expand the substring until a duplicate letter is found
		// delete all of the letters from the start of the substring up through the first instance of the duplicated letter
		// * handled by outside while loop, no need for another inner one. 

		int start = 0;
		int end = 0;

		int longest = 0;

		// storing the characters in the current substring
		HashSet<Character> currentChars = new HashSet<>();

		while(start < s.length() && end < s.length()) {

			char currentChar = s.charAt(end);

			if (!currentChars.contains(currentChar)) {
				currentChars.add(currentChar);
				longest = Math.max(longest, currentChars.size());
				end ++;
			} else {

				char startChar = s.charAt(start);

				currentChars.remove(startChar);

				start ++;

			}

		}

		return longest;





		// brute force: try all substrings, check if they have repeating characters

		/*
		int longest = 0;

		for (int start = 0; start < s.length(); start ++) {
			for (int end = start + 1; end <= s.length(); end ++) {
				String substring = s.substring(start, end);
				if (noRepeatingChars(substring)) {
					longest = Math.max(longest, substring.length());
				}

			}
		}

		return longest; 
		*/

	}

	public boolean noRepeatingChars(String s) {

		HashSet<Character> chars = new HashSet<>();

		for (char c : s.toCharArray()) {
			if (chars.contains(c)) {
				return false;
			}

			chars.add(c);
		}

		return true;

	}

}