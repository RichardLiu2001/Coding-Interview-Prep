class Solution {


    public int[][] merge(int[][] intervals) {
        
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();

        // Sort based on first number
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        result.add(intervals[0]);

        // Tracks the current interval, which will be updated to the interval with the highest
        // starting number when encountered
        int[] currentInterval = intervals[0];
        for (int[] interval : intervals) {

            // merge
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {

                // Add new interval, will be updated in result if there are future merges
                result.add(interval);

                currentInterval = interval;
            }

        }

        int[][] resultArray = new int[result.size()][2];

        for (int i = 0; i < result.size(); i ++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;




    }
}