class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, 0, set, res);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> set, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }
        set.add(nums[i]);
        dfs(nums, target-nums[i], i, set, res);
        set.remove(set.size()-1);
        dfs(nums, target, i+1, set, res);
    }
}
