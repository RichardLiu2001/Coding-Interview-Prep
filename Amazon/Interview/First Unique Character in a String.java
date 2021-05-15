class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freqs = new HashMap<>();

        for (char c : s.toCharArray()) {
        	int freq = freqs.getOrDefault(c, 0);
        	freqs.put(c, freq + 1);
        }

        for (int i = 0; i < s.length(); i ++) {
        	char current = s.charAt(i);
        	if (freqs.get(current) == 1) {
        		return i;
        	}
        }

        return -1;
    }
}