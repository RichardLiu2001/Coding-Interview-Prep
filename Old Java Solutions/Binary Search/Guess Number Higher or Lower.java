/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {

    public int guessNumber(int n) {

    	int right = n;
    	int left = 1;
    	int middle;
    	int result;

    	while (left <= right) {

    		middle = left + (right - left) / 2;

    		result = guess(middle);

    		if (result == 0) {
    			return middle;
    		}

    		if (result == -1) {
    			right = middle - 1;
    		} else {
    			left = middle + 1;
    		}

    	}
    	return left; 
        
    }
}