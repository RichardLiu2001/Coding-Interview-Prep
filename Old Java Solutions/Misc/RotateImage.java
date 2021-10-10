class Solution {
	public void rotate(int[][] matrix) {

		int rows = matrix.length / 2;
		if (matrix.length % 2 == 1) {
			rows ++;
		}

		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < rows; j ++) {
				int current = matrix[i][j];
				int newRow = j;
				int newCol = rows - 1 - i; 
				int temp = matrix[newRow][newCol];
				matrix[newRow][newCol] = current;
				matrix[i][j] = temp;
			}
		}
	}
}