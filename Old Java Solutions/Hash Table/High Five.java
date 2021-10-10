class Solution {
    public int[][] highFive(int[][] items) {
        
        if (items.length == 0) {
        	return new int[0][0];
        }	

        TreeMap<Integer, List<Integer>> scores = new TreeMap<>();

        for (int i = 0; i < items.length; i ++) {
        	for (int j = 0; j < items[0].length; j ++) {


        		int id = items[i][0];
        		int score = items[i][j];

        		if (!scores.containsKey(id)) {
        			scores.put(id, new ArrayList<Integer>());
        		}

        		scores.get(id).add(score);

        	}
        }

        int[][] result = new int[scores.size()][2];

        int resultRow = 0;

        for (Integer key : scores.keySet()) {

        	List<Integer> scoreList = scores.get(key);

        	Collections.sort(scoreList);
        	int total = 0;
        	for (int i = scoreList.length() - 1; i >= scoreList.length() - 5; i --) {
        		total += scoreList.get(i);
        	}

        	total /= 5; 

        	result[resultRow][0] = id;
        	result[resultRow][1] = total; 

        	resultRow ++;

        }

        return reuslt;



    }
}