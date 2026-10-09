class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder(""));
        return res;
    }

    private void backtrack(int n, int open, int close, StringBuilder str){
        if(open==n && close==n){
            res.add(str.toString());
            return;
        }
        if(open<n){
            str.append('(');
            backtrack(n, open+1, close, str);
            str.deleteCharAt(str.length()-1);
        }
        if(open>close){
            str.append(')');
            backtrack(n, open, close+1, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
