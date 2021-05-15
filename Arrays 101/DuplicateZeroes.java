class Solution {
    
	// Naive Solution
    public void duplicateZeros(int[] arr) {
 
    	int index = 0;
    	while (index < arr.length) {
    		
    		if (arr[index] == 0) {
    			insert(0, index, arr);
    			index ++;
    		}
    		index ++;

    	}

    }

    public void insert(int element, int index, int[] arr) {

    	for (int i = arr.length - 1; i > index; i --) {
    		arr[i] = arr[i - 1];
    	}
    	arr[index] = element;

    }

    // Recommended Solution
    public void duplicateZeros(int[] arr) {

        int zeroesToDuplicate = 0;
        int length = 
    }

}