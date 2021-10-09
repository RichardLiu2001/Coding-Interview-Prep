class Solution {
    public String minWindow(String s, String t) {
        

    	if (s.length() == 0 || t.length() == 0) {
    		return "";
    	}

    	// storing each char in t and its corresponding frequency
        HashMap<Character, Integer> tFreqs = new HashMap<>();

        for (char c : tFreqs.toCharArray()) {
        	int freq = tFreqs.getOrDefault(c, 0);
        	tFreqs.put(c, freq + 1);
        }

      	// ans list of the form (window length, left, right)
      	int[] ans = {-1, 0, 0};

        int left = 0;
        int right = 0;

        // number of unique chars in t, which need to be present in the desired window
        int requiredUniqueChars = tFreqs.size(); 

        // keps track of how many unique characters in t are present in the current window in its 
        // desired frequency. 
        int formed = 0;

        // HashMap keeping count of all of he unique characters in the current window
        HashMap<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        while (left < s.length() && right < s.length()) {

        	// add one character from the right to the window
        	char c = s.charAt(right);
        	int count = windowCounts.getOrDefault(c, 0);
        	windowCounts.put(c, count + 1);


         	// if the freq of the current character added equals the desired 
         	// count in t, increment the formed count.
        	if (tFreqs.containsKey(c) && windowCounts.get(c) == tFreqs.get(c)) {
        		formed ++;
        	}

        	// try to contract the window till the point where it ceases to be desirable.
        	while (left <= right && formed == required) {
        		c = s.charAt(left);
        		// save the smallest window until now

        		// if length of current window is smaller than previously found smallest window
        		if (ans[0] == - 1 || right - left + 1 < ans[0]) {
        			ans[0] = right - left + 1;
        			ans[1] = left;
        			ans[2] = right;
        		}

        		// remove the character at "left" from the window
        		windowCounts.put(c, windowCounts.get(c) - 1);

        		if (tFreqs.containsKey(c) && windowCounts.get(c) < tFreqs.get(c)) {
        			formed --;
        		}



        		// shrink window
        		left ++;


        	}

        	// expand window once we are finished contracting
        	right ++;


        }

        if (ans[0] == -1) {
        	return "";
        }

        return s.substring(ans[1], ans[2] + 1);
    }
}