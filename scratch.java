class Solution {
    public int firstUniqChar(String s) {
        
        HashSet<Character> chars = new HashSet<>();

        for (int i = 0; i < s.length(); i ++) {
        	char c = s.charAt(i);
        	if (chars.contains(c)) {
        		return i;
        	}

        	chars.add(c);
        }

        return -1;
    }
}