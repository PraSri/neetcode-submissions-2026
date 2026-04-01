class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        int ans = nums[0];
        for(int i = 1; i<nums.length; i++) {
            curMax = Math.max(nums[i]*preMax, nums[i]*preMin);
            curMax = Math.max(curMax, nums[i]);
            int curMin = Math.min(nums[i]*preMax, nums[i]*preMin);
            curMin = Math.min(curMin, nums[i]);
            ans = Math.max(ans, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return ans;
    }
}
