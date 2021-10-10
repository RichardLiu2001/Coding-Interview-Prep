class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i ++) {
        	for (int j = i + 1; j < intervals.length; j ++) {
        		int[] a = intervals[i];
        		int[] b = intervals[j];
        		if (!canAttend(a, b)) {
        			return false;
        		}
        	}
        }
        return true;
    }

    public boolean canAttend(int[] a, int[] b) {
    	return (a[0] >= b[0] && a[0] >= b[1]) || (b[0] >= a[0] && b[0] >= a[1]); 
    }
}