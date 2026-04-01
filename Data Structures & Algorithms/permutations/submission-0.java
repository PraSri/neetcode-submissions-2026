class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        backtrack(nums, res, pick, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, 
    boolean[] pick, List<Integer> temp) {
        // base case
        if(temp.size() >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(!pick[i]) {
                temp.add(nums[i]);
                pick[i] = true;
                backtrack(nums, res, pick, temp);
                temp.remove(temp.size() - 1);
                pick[i] = false;
            }
        }
    }
}
