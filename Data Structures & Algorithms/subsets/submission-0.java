class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;
    }

    private void dfs(int[] nums, int i , List<List<Integer>> res, List<Integer> subset) {
        // base case 
        // we have processed all the elements
        if(i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // choose curr element
        subset.add(nums[i]);
        dfs(nums, i+1, res, subset);
        // backtrack
        // skip curr element
        subset.remove(subset.size() - 1);
        dfs(nums, i+1, res, subset);
    }
}
