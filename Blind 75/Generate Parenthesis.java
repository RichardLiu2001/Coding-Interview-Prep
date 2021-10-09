class Solution {
    public List<String> generateParenthesis(int n) {
        
        StringBuilder s = new StringBuilder();
        List<String> ans = new ArrayList<>();
        generateHelp(ans, s, 0, 0, n);
        return ans;
    }

    public void generateHelp(List<String> ans, StringBuilder s, int open, int close, int max) {

        if ((open + close) == max * 2) {
            ans.add(s.toString());
            return;
        }

        if (open < max) {

            s.append("(");
            generateHelp(ans, s, open + 1, close, max);
            s.deleteCharAt(s.length() - 1);
        }

        if (close < open) {
            s.append(")");
            generateHelp(ans, s, open, close + 1, max);
            s.deleteCharAt(s.length() - 1);
        }

    }
}