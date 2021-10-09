class Solution {
    public int strStr(String haystack, String needle) {
            
        if (needle.length() == 0) {
            return 0;
        }

        // iterate from beginning of haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {

            int haystackIndex = i;
            int needleIndex = 0;

            while (haystackIndex < haystack.length() && needleIndex < needle.length() && haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
                haystackIndex ++;
                needleIndex ++;
            }

            if (needleIndex == needle.length()) {
                return i;
            }

        }

        // needle not found
        return -1;

    }
}