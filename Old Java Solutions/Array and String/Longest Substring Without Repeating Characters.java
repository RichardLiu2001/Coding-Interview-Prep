class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int len = s.length();

        if (len < 2) {
            return s.length();
        }

        int max = 0;

        HashSet<Character> currentWindow = new HashSet<>();

        int start = 0;
        int end = 0;

        while (start < len && end < len) {

            char endChar = s.charAt(end);

            // expand window to the right
            if (!currentWindow.contains(endChar)) {
                currentWindow.add(endChar);
                end ++;

                max = Math.max(max, currentWindow.size());

            } else {

                // duplicate found on the right. Duplicate exists somewhere in current
                // window (not necessarily the first character)
                while (s.charAt(start) != endChar) {
                    currentWindow.remove(s.charAt(start));

                    start ++;

                }
                currentWindow.remove(s.charAt(start));

                start ++;

            }

        }

        return max;

    }


     public static int lengthOfLongestSubstringImproved(String s) {
        
        int len = s.length();

        if (len < 2) {
            return s.length();
        }

        int max = 0;

        HashMap<Character, Integer> charIndices = new HashMap<>();

        int start = 0; 
        for (int end = 0; end < s.length(); end ++) {

            char endChar = s.charAt(end);

            if (charIndices.containsKey(endChar)) {
                start = Math.max(start, charIndices.get(endChar));

            }

            max = Math.max(max, end - start + 1);
            charIndices.put(endChar, end + 1);

        }

        return max;

    }

}