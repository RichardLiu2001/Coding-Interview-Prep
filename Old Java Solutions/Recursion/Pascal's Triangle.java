class Solution {
    public List<List<Integer>> generate(int numRows) {


        
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if (numRows == 0) {
        	return triangle;
        }


        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);


        for (int i = 1; i < numRows; i ++) {

        	List<Integer> newRow = new ArrayList<Integer>();
        	newRow.add(1);
            
        	List<Integer> previous = triangle.get(triangle.size() - 1);

        	for (int j = 1; j < previous.size(); j ++) {
        		int newSum = previous.get(j) + previous.get(j - 1);
        		newRow.add(newSum);
        	}

        	newRow.add(1);
        	triangle.add(newRow);

	        
	    } 

	    return triangle;


    }
}