class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character, Character> correspondingBrackets = new HashMap<>();
        correspondingBrackets.put(')','(');
        correspondingBrackets.put(']', '[');
        correspondingBrackets.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
        	char c = s.charAt(i);
        	if (correspondingBrackets.containsKey(c)) {
                
                
        		char topElement = stack.empty() ? '#' : stack.pop();
        		if (topElement != correspondingBrackets.get(c)) {
        			return false;
        		}
        	} else {
        		stack.push(c);
        	}

        }
        return stack.empty();
}
}