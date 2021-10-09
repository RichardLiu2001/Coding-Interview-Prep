class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
        	return "";
        }

        // hashmap storing the frequencies of all of the letters in t
        HashMap<Character, Integer> chars = new HashMap<>();

   		// updating chars
        for (int i = 0; i < t.length(); i ++) {

        	char currentChar = t.charAt(i);
        	int currentFreq = chars.getOrDefault(currentChar, 0);
        	chars.put(currentChar, currentFreq + 1);

        }

        int required = chars.size();

        int left = 0;
        int right = 0;

        // indicates how many distinct letters in t are satisfied in the current window
        int formed = 0;

        // answer: window length, left, right
        int[] ans = {-1, 0, 0};

        HashMap<Character, Integer> windowCounts = new HashMap<Character, Integer>();


        while (r < s.length()) {
        	char c =  s.charAt(i);
        	int count = windowCounts.getOrDefault(c, 0);
        	windowCounts.put(c, count + 1);

        	if (chars.containsKey(c) && windowCounts.get(c).intValue() == chars.get(c).intValue()) {
        		formed ++;
        	}

        	while (l <= r && formed == required) {
        		c = s.charAt(l);
        		if (ans[0] == -1 || r - l + 1 < ans[0])
        	}



        }



    }
}