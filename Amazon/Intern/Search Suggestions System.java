class Solution {        
    
    public static int getLowerBound(String[] products, int start, String word) {
    	int low = start;
    	int high = products.length;
    	int mid;
    	
    	while (low < high) {

   			mid = (low + high) / 2;

    		if (word.compareTo(products[mid]) <= 0) {
   				high = mid;
   			} else {
   				low = mid + 1;
   			}
	   	}

   		return low;

    }

   	public List<List<String>> suggestedProducts(String[] products, String searchWord) {

   		Arrays.sort(products);
   		List<List<String>> result = new ArrayList<>();

   		int start = 0;
   		int searchStart = 0;
   		int n = products.length; 

   		String prefix = "";
   		for (char c : searchWord.toCharArray()) {
   			prefix += c;

   			start = getLowerBound(products, searchStart, prefix);

   			ArrayList<String> suggestions = new ArrayList<>();
   			

   			for (int i = start; i < Math.min(start + 3, n); i ++) {
   				if (products[i].length() < prefix.length() || 
   					!products[i].substring(0, prefix.length()).equals(prefix)) {
   					break;
   				}

   				suggestions.add(products[i]);


   			}

   			result.add(suggestions);
    
            searchStart = start;

   		}

   		return result;

    }
}