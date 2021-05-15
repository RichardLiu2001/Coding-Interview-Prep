class Solution {
    public int mySqrt(int x) {
        
        if (x < 2) {
            return x; 
        }
        
        int left = 2;
        int right = x / 2;
        int middle;
        
        while (left <= right) {

            middle = left + (right - left) / 2;

            long square = (long) middle * middle;

            if (square == x) {
                return middle;
            }
            
            if (square < x) {

                left = middle + 1;
            } else {
                right = middle - 1;
            }
            
        }

        // right will be smaller than left, and left ^2 is > x
        return right;   
            
    }
}