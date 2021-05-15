class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, LinkedList<String>> anagrams = new HashMap<>();
        
        for (String s : strs) {
            
            String sorted = sortString(s);
            
            if (anagrams.containsKey(sorted)) {
                anagrams.get(sorted).add(s);
            } else {
                LinkedList<String> list = new LinkedList<>();
                
                list.add(s);
                anagrams.put(sorted, list);
            }
        }
        
        List result = new ArrayList<>();
        
        for (String key : anagrams.keySet()) {
            result.add(anagrams.get(key));
        }
        return result;
    }
    
    public String sortString(String s) {
        
        char[] chars = new char[s.length()];
        
        for (int i = 0; i < s.length(); i ++) {
            chars[i] = s.charAt(i);
        }
        
        Arrays.sort(chars);
        
        String result = "";
        for (char c : chars) {
            result += c;
        }
        
        return result;
        
        
    }

    public List<List<String>> groupAnagrams(String [] strs) {

        if (strs.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> ans = new HashMap<>();
        int [] count = new int[26];

        for (String s : strs) {
            for (char c : s.toCharArray()) {
                count[c - 'a'] ++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i ++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }

}