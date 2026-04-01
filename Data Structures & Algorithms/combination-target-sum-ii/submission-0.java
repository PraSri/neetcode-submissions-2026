class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, res, subset,  target);
        return res;
    }

    private void dfs(int[] nums, int i ,
     List<List<Integer>> res, List<Integer> subset, int t) {
        // base case
        // found a valid combination
        if(t==0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // invalid path: sum too big or out of numbers
        if(t<0 || i>=nums.length) {
            return;
        }

        // choose curr 
        subset.add(nums[i]);
        // we don't move to next number, allow re-use of same number
        dfs(nums, i+1, res, subset, t-nums[i]);

        // backtrack, don't use this curr
        subset.remove(subset.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        dfs(nums, i+1, res, subset, t);
    }
}
