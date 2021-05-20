class Solution {
    public String countAndSay(int n) {
        	
        String current_say = "1";
        for (int i = 1; i < n; i ++) {
        	current_say = getSay(current_say);
        }
        return current_say;

    }

    public String getSay(String s) {

    	if (s.length() == 0) {
    		return "";
    	}

    	result = new StringBuilder();
    	
    	int count = 0;
    	char consecutive_num = s.charAt(0);

    	for (int i = 0; i < s.length(); i ++) {

    		char current_num = s.charAt(i);

    		if (current_num == consecutive_num) {

    			count ++;
    		} else {
    			result.append(count);
    			result.append(s.charAt(i - 1));
    			count = 1;
    			consecutive_num = current_num;
    		}
    	}

    	result.append(count);
    	result.append(s.charAt(s.charAt(s.length() - 1)));

    	return result.toString();


    }

}