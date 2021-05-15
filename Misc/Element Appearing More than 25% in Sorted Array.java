class Solution {
    public int findSpecialInteger(int[] arr) {
        int window = arr.length / 4;
        
        for (int i = 0; i < arr.length - window; i ++) {
            
            if (arr[i] == arr[i + window]) {
                return arr[i];
            }   
            
        }
            
        return -1;
    }
}