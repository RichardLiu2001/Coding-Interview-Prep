class Solution {
    public String longestPalindrome(String s) {
    	
    	if (s.length() < 2) {
    		return s;
    	}

    	String longestPalindrome = "";
    	boolean[][] dp = new boolean[s.length()][s.length() + 1];
    	for (int i = 0; i < s.length(); i ++) {
    		dp[i][i + 1] = true;

    		if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
    			dp[i][i + 2] = true;
    		}
    	} 

    	String longest = "";

    	for (int i = 0; i < s.length(); i ++) {
    		for (int j = i + 1; j <= s.length(); j ++) {

                

    				
    			//String substring = s.substring(i, j);
    			//if (isPalindrome(substring) && substring.length() > longestPalindrome.length()) {
    			//	longestPalindrome = substring;
    			//}

    		}
    	}	

    	return longestPalindrome;

    }

    public boolean isPalindrome(String s) {

    	if (s.length() < 2) {
    		return true;
    	}

    	for (int i = 0; i < s.length() / 2; i ++) {

    		if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
    			return false;
    		}

    	}

    	return true;

    }

    // aracecara
    // bab
    // bb

}