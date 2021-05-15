class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

    	HashSet<String> bannedWords = new HashSet<>();

    	for (String s : banned) {
    		bannedWords.add(s);
    	}

    	HashMap<String, Integer> wordFreqs = new HashMap<>();

        Scanner sc = new Scanner(normalizedStr);
        while (sc.hasNext()) {
        	String word = sc.next();

        	if (!bannedWords.contains(word)) {
        		int freq = wordFreqs.getOrDefault(word, 0);
        		wordFreqs.put(word, freq + 1);
        	}

        }

        String maxWord = "";
        int maxFreq = 0;

        for (String word : wordFreqs.keySet()) {

        	int freq = wordFreqs.get(word);
        	if (freq > maxFreq) {
        		maxWord = word;
        		maxFreq = freq;
        	}

        }

        return maxWord;


    }
}