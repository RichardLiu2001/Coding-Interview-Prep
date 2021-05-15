class Solution {

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        boolean foundPeak = false;
        int previous = A[0];
        int index = 1;
        int peakIndex = 0;
        while (!foundPeak && index < A.length) {
            System.out.println(A[index]);
            if (A[index] < previous) {
                foundPeak = true;
                peakIndex = index - 1;
            }

            if (A[index] == previous) {
                return false;
            }
            previous = A[index];
            index ++;
        }

        while (foundPeak && index < A.length) {
            if (previous <= A[index]) {
                return false;
            }
            previous = A[index];
            index ++;
        }
        return foundPeak && index == A.length && peakIndex != 0 && peakIndex != A.length;
    }


    // Recommended Solution
    public boolean validMountainArray(int[] A) {

        int length = A.length;
        int i = 0;

        // walk up, stop at peak

        // if i + 1 is in bounds and i is less than the next, increment i 
        while (i + 1 < length && A[i] < A[i + 1]) {
            i ++;
        }

        // i is now equal to the peak

        if (i == 0 || i == length - 1) {
            return false; 
        }

        while (i + 1 < length && A[i + 1] < A[i]) {
            i ++;
        }

        // i is the index in which the while loop ends, either an invalid mountain or the end

        return i == length - 1;

    }

















}