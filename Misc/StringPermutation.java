class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freqs = new int[26];
        int[] s1Copy = new int[26];
        int[] s2Freqs = new int[26];

        for (int i = 0; i < s1.length(); i ++) {
            char currentChar = s1.charAt(i);
            s1Freqs[(int) (currentChar - 97)] ++;
            s1Copy[(int) (currentChar - 97)] ++;
        }

        for (int i = 0; i < s2.length(); i ++) {
            char currentChar = s2.charAt(i);
            s2Freqs[(int) (currentChar - 97)] ++;
        }

        for (int i = 0; i < s2.length(); i ++) {
            int currentIndex = (int) (s2.charAt(i) - 97);
            if (s1Freqs[currentIndex] > 0) {
                s1Freqs[currentIndex] --;
                if (allZero(s1Freqs)) {
                    return true;
                }
            } else {
                reset(s1Freqs, s1Copy);
            }
        }
        return false; 
    }

    public static void reset(int[] s1, int[]s1Copy) {
        for (int i = 0; i < s1.length; i ++) {
            s1[i] = s1Copy[i];
        }
    }

    public static boolean allZero(int[] s1) {
        for (int i = 0; i < s1.length; i ++) {
            if (s1[i] != 0) {
                return false;
            }
        }
        return true; 
    }
}