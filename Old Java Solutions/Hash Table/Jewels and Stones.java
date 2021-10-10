class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
    	HashSet<Character> jewelList = new HashSet<>();

    	for (int i = 0; i < jewels.length(); i ++) {
    		jewelList.add(jewels.charAt(i));
    	}

    	int result = 0;

    	for (int i = 0; i < stones.length(); i ++) {
    		if (jewelList.contains(stones.charAt(i))) {
    			result ++;
    		}
    	}
    	return result;

    }
}