class Solution {
    public int strStr(String haystack, String needle) {
        	
    	if (haystack.length() < needle.length()) {
    		return -1; 
    	}

    	if (needle.length() == 0) {
    		return 0;
    	}

    	for (int i = 0; i < haystack.length() - needle.length() + 1; i ++) {

    		if (haystack.substring(i, needle.length() + i).equals(needle)) {
    			return i;
    		}

    	}
    	return -1; 

    }
}