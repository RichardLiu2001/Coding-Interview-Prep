class Solution {
    public List<Integer> getRow(int rowIndex) {

    	List<Integer> result = new ArrayList<Integer>();
    	result.add(1);

    	if (rowIndex == 0) {
    		return result;
    	}

    	result.add(1);

    	if (rowIndex == 1) {
    		return result; 
    	}


        getRowHelp(result, rowIndex, 1);

        return result;

    }

    public void getRowHelp(List<Integer> currentNums, int rowIndex, int currentRow) {

    	if (rowIndex == currentRow) {
    		return; 
    	}

    	int oldSize = currentNums.size();
    	int newVal;

    	for (int i = 1; i < oldSize; i ++) {
    		newVal = currentNums

    		currentNums.set(i, )
    	}






    }

}