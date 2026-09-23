class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> cur, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i>=candidates.length || candidates[i]> target){
            return;
        }
        cur.add(candidates[i]);
        dfs(candidates, target-candidates[i], i+1, cur, res);
        cur.remove(cur.size()-1);
        while(i+1<candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(candidates, target, i+1, cur, res);
    }
}
