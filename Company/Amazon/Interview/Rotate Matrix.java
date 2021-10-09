class Solution {
    public void rotate(int[][] matrix) {
        
    	if (matrix == null || matrix.length == 0) {
    		return;
    	}


    	// transpose 
    	for (int i = 0; i < matrix.length; i ++) {
    		for (int j = 0; j < i; j ++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = temp;
    		}
    	}

    	// reverse rows

    	for (int i = 0; i < matrix.length; i ++) {
    		for (int j = 0; j < matrix[i].length / 2; j ++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[i][matrix.length - j - 1];
    			matrix[i][matrix.length - j - 1] = temp;
    		}
    	}

    	

    }
}