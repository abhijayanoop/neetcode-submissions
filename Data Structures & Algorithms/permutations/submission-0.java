class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] exists, List<Integer> cur){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!exists[i]){
                cur.add(nums[i]);
                exists[i] = true;
                backtrack(nums, exists, cur);
                cur.remove(cur.size()-1);
                exists[i] = false;
            }
        }
    }
}
