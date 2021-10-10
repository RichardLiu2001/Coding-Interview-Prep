class Solution {
    public boolean isPalindrome(int x) {
        String number = x + "";
        for (int i = 0; i < number.length() / 2; i ++) {
        	if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
        		return false;
        	}
        }

        return true;

    }

    public boolean isPalindrome(int x) {
    	if (x < 0 || (x % 10 == 0 && x != 0)) {
    		return false; 
    	}

    	int revertedNumber = 0;
    	while (x > revertedNumber )


    }
}