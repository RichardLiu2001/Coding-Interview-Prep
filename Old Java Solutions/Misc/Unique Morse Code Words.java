class Solution {
    public int uniqueMorseRepresentations(String[] words) {

    	if (words.length == 0) {
    		return 0;
    	}
        
		String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		HashSet<String> morses = new HashSet<String>();
		for (String word : words) {
			String code  = "";
			for (int i = 0; i < word.length(); i ++) {
				char currentChar = word.charAt(i);
				int codeIndex = (int) currentChar - 'a';
				code += codes[codeIndex];
			}
			morses.add(code);
		}

		return morses.size();
    }
}