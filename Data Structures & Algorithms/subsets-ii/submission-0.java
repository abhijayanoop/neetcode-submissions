class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> cur, int i){
        if(i==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, cur, i+1);
        cur.remove(cur.size()-1);
        while(i+1<nums.length && nums[i] == nums[i+1]){
            i++;
        }
        backtrack(nums, cur, i+1);
    }
}
