class Solution {
    public int longestPalindrome(String s) {
        	
        HashMap<Character, Integer> freqs = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
        	char current = s.charAt(i);

        	int freq = freqs.getOrDefault(current, 0);
        	freqs.put(current, freq + 1);
        }

        int result = 0;
        boolean odd = false;

        for (char letter : freqs.keySet()) {

        	int freq = freqs.get(letter);
            result += freq / 2 * 2;

            if (freq % 2 == 1) {
            	odd = true;
            }

        }

        if (odd) {
        	result ++;
        }

        return result;




    }
}