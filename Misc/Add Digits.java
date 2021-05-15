class Solution {
    public int addDigits(int num) {
    	while (num > 9) {
    		num = sumOfDigits(num);
    	}

    	return num;

    }

    public int sumOfDigits(int num) {
    	int result = 0;
    	while (num > 0) {
    		result += num % 10;
    		num /= 10;
    	}

    	return result;
    }
}