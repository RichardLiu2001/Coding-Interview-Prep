class Solution {
    public boolean exist(char[][] board, String word) {
        
    	for (int i = 0; i < board.length; i ++) {
    		for (int j = 0; j < board[0].length; j ++) {
    			if (existHelp(board, word, 0, i, j)) {
    				return true;
    			}
    		}
    	}
    	return false;

    }


    public boolean existHelp(char[][] board, String word, int index, int row, int col) {

      // check this first because out of bounds may occur even if the word is found. (the last letter of the word is on the edge)
      if (index >= word.length()) {
  			return true; 
  		}
  		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
  			return false; 
  		}

  		if (word.charAt(index) != board[row][col]) {
  			return false;
  		} 

  		char oldChar = board[row][col];

  		board[row][col] = '#';

  		int[] rowDirs = {-1, 0, 0, 1};
  		int[] colDirs = {0, -1, 1, 0};

  		for (int i = 0; i < 4; i ++) {
 
  			if (existHelp(board, word, index + 1, row + rowDirs[i], col + colDirs[i])) {
  				return true;
  			}
  		}

  		board[row][col] = oldChar;
  		return false; 



    }
}