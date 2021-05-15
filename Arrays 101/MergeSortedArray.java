class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        	
    	int nums1Index = 0;
    	int nums2Index = 0;

    	for (int i = 0; i < nums1.length; i ++) {
    		int nums1Num = nums1[nums1Index];
    		int nums2Num = nums2[nums2Index];

    		if (nums1Num < nums2Num) {
    			nums1[i] = nums1Num;
    			nums1Index ++;
    		} else {
    			nums1[i] = nums2Num;
    			nums2Index ++;
    		}

    	}

    }

    //Naive Solution using Arrays.sort

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] result = new int[m + n];

    	for (int i = 0; i < m; i ++) {
    		result[i] = nums1[i];
    	}

    	for (int i = 0; i < n; i ++) {
    		result[i + m] = nums2[i];
    	}

    	Arrays.sort(result);

    	for (int i = 0; i < result.length; i ++) {
    		nums1[i] = result[i];
    	}

    }


}