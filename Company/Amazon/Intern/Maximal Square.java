class Solution {
    public int maximalSquare(char[][] matrix) {

    	int maxSquareSize = 0;

        for (int i = 0; i < matrix.length) {
        	for (int j = 0; j < matrix[0].length) {
        		if (matrix[i][j] == '1') {
        			int squareSize = getSquareSize(i, j, matrix);
        			maxSquareSize = Math.max(maxSquareSize, squareSize);
        		}
        	}
        }

        return maxSquareSize;
    }

    public int getSquareSize(int row, int col, char[][] matrix) {

    	int sqlen = 1;
    	boolean valid = true;

    	while (sqlen + row < matrix.length && sql + col < matrix[0].length && valid) {

    		for (int k = col; k <= sqlen + col; k +)
    	}
    }


}