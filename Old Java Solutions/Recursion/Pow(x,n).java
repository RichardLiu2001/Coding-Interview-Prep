class Solution {
    public double myPow(double x, int n) {
        
    	// brute force, multiply x by itself n times
    	/*
    	for (int i = 0; i < Math.abs(n), i ++) {

    		x *= x;

    	}

    	if (n < 0) {
    		return 1 / x;
    	}

    	return x;
    	*/
    	
    	if (n < 0) {
    		x = 1 / x;
    	}

    	return fastPow(x, Math.abs(n));


    }


    public double fastPow(double x, int n) {

    	// base case, n is 0

    	if (n == 0) {

    		return 1;
    	}

    	double halfPow = fastPow(x, n / 2);

    	if (n % 2 == 0) {
    		return halfPow * halfPow;
    	}

    	return halfPow * halfPow * x;
    }
}