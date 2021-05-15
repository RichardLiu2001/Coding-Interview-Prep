class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int shortestDistance = words.length;
    	for (int i = 0; i < words.length; i ++) {
    		String current = words[i];
    		if (current.equals(word1)) {

    			for (int j = 0; j < words.length; j ++) {
    				String current2 = words[j];
    				if (current2.equals(word2)) {
    					int distance = Math.abs(j - i);
    					shortestDistance = Math.min(shortestDistance, distance);
    				}
    			}

    		}
    	}
    	return shortestDistance;

    }

    public int shortestDistance(String[] words, String word1, String word2) {

    	int idx1 = -1;
    	int idx2 = -1;
    	int shortestDistance = words.length;

    	for (int i = 0; i < words.length; i ++) {
    		String currentWord = words[i];
    		if (currentWord.equals(word1)) {
    			idx1 = i;
    		}

    		if (currentWord.equals(word2)) {
    			idx2 = i;
    		}

    		if (idx1 != -1 && idx2 != -1) {
    			shortestDistance = Math.min(shortestDistance, Math.abs(idx1 - idx2));

    		}

    	}

    	return shortestDistance;


    }
}