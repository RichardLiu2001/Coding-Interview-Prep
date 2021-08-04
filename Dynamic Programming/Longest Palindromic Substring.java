class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();

        if (len < 2) {
            return len;
        }
        
        // substrings[i][j] indicates whether the substring starting at i and ending at j is a palindromic
        boolean[][] substrings = new boolean[len][len];

        // fill in single / double letters

        for (int i = 0; i < len; i ++) {
            
            // single letters
            substrings[i][i] = true;

            if (i < len - 1) {

                if (s.charAt(i) == s.charAt(i + 1)) {
                    substrings[i][i + 1] = true;
                }

            }
        }

        // check all substrings

        String longest = "";
        for (int i = 0; i < len; i ++) {
            for (int j = i; j < len; j ++) {

                if (substrings[i][j] && inBounds(i, j, len)) {

                    if (s.charAt(i - 1) == s.charAt(j + 1)) {

                        substrings[i - 1][j + 1] = true;

                        if (j + 1 - (i - 1) + 1 > longest.length()) {
                            longest = s.substring(i - 1, j + 2);
                        }

                    }

                }

            }
        }

        return longest;




    }

    public boolean inBounds(int i, int j, int len) {
        return i - 1 >= 0 && j + 1 < len;
    }
}