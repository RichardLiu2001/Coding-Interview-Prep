class Solution {
    public boolean isIsomorphic(String s, String t) {
        
    	if (s.length() != t.length()) {
    		return false; 
    	}

    	// Need to construct the mapping e -> a and g -> d
    	// instead of directly mapping e to a (hard to get key from value), mark them with the same value:
    	// e -> 1, a -> 1



    	int[] m1 = new int[256];
    	int[] m2 = new int[256];

    	// traverse each string on the same position, if their mapping values in m1 and m2 are different, return false
    	// else, construct the mapping

    	// we can use i + 1 as a unique value for the mapping, because it hasn't appeared yet

    	for (int i = 0; i < s.length(); i ++) {

    		int sIndex = (int) (s.charAt(i));
    		int tIndex = (int) (t.charAt(i));

    		if (m1[sIndex] != m2[tIndex]) {
    			return false;
    		}

    		m1[sIndex] = i + 1;
    		m2[tIndex] = i + 1;

    	}

    	return true;

    }
}