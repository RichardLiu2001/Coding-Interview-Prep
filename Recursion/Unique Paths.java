class Solution {
    public int uniquePaths(int m, int n) {
    	
    	return pathsHelp(0, 0, m, n);

    }

    public int pathsHelp(int currentM, int currentN, int m, int n) {

    	if (currentM == m || currentN == n) {
    		return 0;
    	}

    	if (currentM == m - 1 && currentN == n - 1) {
    		return 1;
    	}

    	return pathsHelp(currentM + 1, currentN, m, n) + pathsHelp(currentM, currentN + 1, m, n);
    }

}