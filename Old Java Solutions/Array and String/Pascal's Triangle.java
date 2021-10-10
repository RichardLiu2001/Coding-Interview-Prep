class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        if (numRows < 1) {
            return result;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);

        result.add(first);

        for (int currRowIndex = 1; currRowIndex < numRows; currRowIndex ++) {

            List<Integer> prevRow = result.get(currRowIndex - 1);

            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);

            int prevRowLength = result.get(currRowIndex - 1).size();
            for (int prevRowIndex = 1; prevRowIndex < prevRowLength; prevRowIndex ++) {
                int sum = prevRow.get(prevRowIndex) + prevRow.get(prevRowIndex - 1);
                currRow.add(sum);
            }

            currRow.add(1);

            result.add(currRow);

        }

        return result;
    }
}