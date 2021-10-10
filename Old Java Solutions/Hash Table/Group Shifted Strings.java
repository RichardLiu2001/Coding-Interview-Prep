class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
    	HashMap<String, List<String>> mappings = new HashMap<>();
    	String mapped;
        for (String s : strings) {

        	mapped = mapToFront(s);

        	if (!mappings.containsKey(mapped)) {
        		mappings.put(mapped, new ArrayList<String>());
        	}

        	mappings.get(mapped).add(s);
        }

        List result = new ArrayList<>();

        for (String key : mappings.keySet()) {
        	result.add(mappings.get(key));
        } 
        return result;


    }

    public String mapToFront(String s) {

    	int difference;
    	String result = "";

    	for (int i = 0; i < s.length(); i ++) {

    		char current = s.charAt(i);

    		if (i == 0) {
    			difference = (int) ('a' - current);
    		}

    		char added = (char) ((int) current + difference); 
    		if (added < 'a') {
    			added = (26 + (int) added);
    		}

    		result += added;
    	}
    	return result; 

    }
}