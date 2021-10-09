class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    	List<List<String>> result = new ArrayList<>();

    	HashMap<String, List<String>> anagrams = new HashMap<>();

    	for (String s : strs) {

    		String sorted = sortString(s);

    		if (!anagrams.containsKey(sorted)) {

    			List<String> newList = new LinkedList<>();
    			newList.add(s);
    			anagrams.put(sorted, newList);

    		} else {

    			List<String> anagramList = anagrams.get(sorted);
    			anagramList.add(s);

    		}
    	}

    	for (String anagram : anagrams.keySet()) {
    		List<String> anagramList = anagrams.get(anagram);
    		result.add(anagramList);
    	}

    	return result;





    }

    public String sortString(String s) {

    	char[] letters = s.toCharArray();
    	Arrays.sort(letters);
    	String result = "";
    	for (char c : letters) {
    		result += c;
    	}

    	return result;

    }
}