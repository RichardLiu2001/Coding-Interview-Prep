class Solution {
    public int[] replaceElements(int[] arr) {
    	if (arr.length == 0) {
    		return arr;
    	}

        int rightMax = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i --) {
            int oldElement = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(rightMax, oldElement);
        }

        arr[arr.length - 1] = -1;

        return arr; 
    }
}