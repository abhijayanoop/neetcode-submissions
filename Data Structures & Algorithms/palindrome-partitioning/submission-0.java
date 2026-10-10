class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(String s, List<String> cur, int i){
        if(i>=s.length()){
            res.add(new ArrayList<>(cur));
        }

        for(int j=i; j<s.length(); j++){
            if(isPali(s, i, j)){
                cur.add(s.substring(i, j+1));
                backtrack(s, cur, j+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPali(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
