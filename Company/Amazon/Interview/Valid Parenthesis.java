class Solution {
    public boolean isValid(String s) {
        
    	if (s.length() == 0) {
        	return true;
        }

        HashMap<Character, Character> closingParenthesis = new HashMap<>();
        closingParenthesis.put(')', '(');
        closingParenthesis.put(']', '[');
        closingParenthesis.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
        	if (stack.isEmpty()) {
        		stack.push(c);
        	} else {

        		// is a closing parenthesis
        		if (closingParenthesis.containsKey(c)) {

        			char top = stack.pop();

        			// invalid parenthesis
        			if (top != closingParenthesis.get(c)) {
        				return false;
        			}

        		} else {
        			// is an opening parenthesis
        			stack.push(c);
        		}
        	}
        }

        return stack.isEmpty();




    }
}