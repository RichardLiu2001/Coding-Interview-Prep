class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
        	return result;
        }

        int row = 0;
        int col = 0;

        int spirals = Math.min(matrix.length, matrix[0].length) / 2;

        for (int spiral = 0; spiral < spirals; spiral ++) {

        	row = spiral;
        	col = spiral;


        	for (int i = 0; i < matrix[0].length - 2 * spiral; i ++) {
        		result.add(matrix[row][col]);
        		col ++;

        	}
        	col --;

        	for (int i = 0; i < matrix.length - 2 * spiral; i ++) {
        		result.add(matrix[row][col]);
        		row ++;

        	}
        	row --;
        	



        }




    }
}