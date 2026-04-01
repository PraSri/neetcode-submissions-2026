class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) {
            return 0;
        }
        if(n<2) {
            return nums[0];
        }
        // rob 1st house, not last
        int[] dp = new int[n+1];

        // rob last house, not 1st
        int[] dp2 = new int[n+1];

        dp[0] = 0;
        dp[1] = nums[0];

        dp2[0] = 0;
        dp2[1] = 0;
        for(int i = 2;i<=n;i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
            dp2[i] = Math.max(nums[i-1] + dp2[i-2], dp2[i-1]);
        }

        return Math.max(dp[n-1], dp2[n]);
    }
}
