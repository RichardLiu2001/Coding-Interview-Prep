class Solution {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		HashSet<Character> charSet = new HashSet<>();

		int result = 0;
		int i = 0;
		int j = 0;

		while (i < n && j < n) {
			char currentChar = s.charAt(j);
			if (!charSet.contains(currentChar)) {
				charSet.add(currentChar);
				j++;
				result = Math.max(result, j - i);

			} else {
				i ++;
				charSet.remove(s.charAt(i));
			}
		}

		return result;

	}

    public int lengthOfLongestSubstring(String s) {

    	int result = 0;

        for (int i = 0; i < s.length(); i ++) {

        	for (int j = i + 1; j <= s.length(); j ++) {
        		String sub = s.substring(i, j);
        		if (allUnique(sub)) {
        			result = Math.max(result, sub.length());
        		}
        	}


        }

        return result;
    }

    public boolean allUnique(String s) {

    	HashSet<Character> characters = new HashSet<>();

    	for (int i = 0; i < s.length(); i ++) {
    		char current = s.charAt(i);
    		if (characters.contains(current)) {
    			return false;
    		}

    		characters.add(current);

    	}

    	return true; 

    }
}