class Solution {
    public int heightChecker(int[] heights) {
        int[] original = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        
        int result = 0;
        for (int i = 0; i < heights.length; i ++) {
            if (original[i] != heights[i]) {
                result ++;
            }
        }
        return result;
    }

    // DOnt understand counting sort solution
} 