public void zeroMatrix(int[] matrix) {

	boolean firstRowZero = false;
	boolean firstColZero = false;
	for (int i = 0; i < matrix[0].length; i ++) {

		if (matrix[0][i] == 0) {
			firstRowZero = true;
			break;
		}
	}

	for (int i = 0; i < matrix.length; i ++) {

		if (matrix[i][0] == 0) {
			firstColZero = true;
			break;
		}
	}

	for (int row = 1; row < matrix.length; row ++) {
		for (int col = 1; col < matrix[0].length; col ++) {
			if (matrix[row][col] == 0) {

				matrix[0][col] = 0;
				matrix[row][0] = 0;
			}
		}
	}

	for (int i = 1; i < matrix.length; i ++) {

		if (matrix[i][0] == 0) {
			nullifyRow(matrix, i);
		}

	}

	for (int i = 1; i < matrix[0].length; i ++) {

		if (matrix[0][i] == 0) {
			nullifyColumn(matrix, i);
		}
	}

	if (firstRowZero) {
		nullifyRow(matrix, 0);
	}

	if (firstColZero) {
		nullifyColumn(matrix, 0);
	}

}

public void nullifyRow(int[] matrix, int row) {

	for (int i = 0; i < matrix[0].length; i ++) {
		matrix[row][i] = 0;
	}

}

public void nullifyColumn(int[] matrix, int col) {

	for (int i = 0; i < matrix.length; i ++) {
		matrix[i][col] = 0;
	}
}