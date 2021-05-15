class Solution {


	public int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
    
        HashSet<Integer> cacheNums = new HashSet<>();

    	LinkedList<Integer> cache = new LinkedList<>();

    	int misses = 0;

    	for (int n : pages) {
    		if (cacheNums.contains(n)) {

    			cache.removeFirstOccurrence(n);
    			cache.addLast(n);

    		} else {
    			misses ++;
    			cache.addLast(n);
    			cacheNums.add(n);
    			if (cache.size() > maxCacheSize) {
    				int first = cache.remove();
    				cacheNums.remove(first);
    			}
    		}
    	}

    	return misses; 

    }





}