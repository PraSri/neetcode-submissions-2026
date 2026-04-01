class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+2];
        a[0] = 1;
        a[n+1] = 1;
        for(int i = 0;i<n;i++) {
            a[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(a, 1, a.length - 2, dp);
    }

    private int dfs(int[] a, int i, int j, int[][] dp) {
        if(i > j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = 0;
        for(int k = i; k<=j; k++) {
            int coins = a[i-1] * a[k] * a[j+1];
            coins += dfs(a, i, k-1, dp) + dfs(a, k+1, j, dp);
            dp[i][j] = Math.max(dp[i][j], coins);
        }
        return dp[i][j];
    }
}
