class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDifference = releaseTimes[0];
        char bestChar = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int difference = releaseTimes[i] - releaseTimes[i-1];
            char currentChar = keysPressed.charAt(i);
            
            if (difference > maxDifference || 
                (difference == maxDifference && currentChar > bestChar)) {
                maxDifference = difference;
                bestChar = currentChar;
            }
        }
        return bestChar;
    }
}