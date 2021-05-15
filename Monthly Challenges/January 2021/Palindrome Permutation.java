class Solution {
    public boolean canPermutePalindrome(String s) {
        
    	HashMap<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
        	
        	char currentChar = s.charAt(i);
        	int freq = chars.getOrDefault(currentChar, 0);
        	chars.put(currentChar, freq + 1);
        }

        int oddCount = 0;

        for (char c : chars.keySet()) {
        	int freq = chars.get(c);
        	if (freq % 2 == 1) {
        		oddCount ++;
        	}
        }

        return oddCount <= 1;

    }
}