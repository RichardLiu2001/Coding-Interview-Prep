class Solution {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
        	char current = s.charAt(i);

        	if (!isAVowel(current)) {
        		sb.append(current);
        	}

        }

        return sb.toString();

    }

    public boolean isAVowel(char c) {
    	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}