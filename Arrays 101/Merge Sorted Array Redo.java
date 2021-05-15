class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    	int nums1Index = m - 1;
    	int nums2Index = n - 1;
    	int insertIndex = m + n - 1;

    	while (nums1Index >= 0 && nums2Index >= 0) {

    		int nums1Val = nums1[nums1Index];
    		int nums2Val = nums2[nums2Index];

    		if (nums1Val > nums2Val) {
    			nums1[insertIndex] = nums1Val;
    			nums1Index --;
    		} else {
    			nums1[insertIndex] = nums2Val;
    			nums2Index --;
    		}

    		insertIndex --;

    	}

    	if (nums1Index < 0) {
    		for (int i = 0; i <= nums2Index; i ++) {
    			nums1[i] = nums2[i];
    		}

    	}

    }
}