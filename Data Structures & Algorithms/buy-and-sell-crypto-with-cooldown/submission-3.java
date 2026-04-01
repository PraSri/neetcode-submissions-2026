class Solution {
    public int maxProfit(int[] prices) {
        // return dfs(0, prices, true);
        int[][] dp = new int[prices.length+1][2];
        for(int i = 0;i<=prices.length;i++) {
            for(int j = 0; j<2; j++) {
                dp[i][j] = -1;
            }
        }
        return dfsMemo(0, prices, 1, dp); 
    }

    private int dfs(int i, int[] p, boolean buy) {
        if(i>=p.length) {
            return 0;
        }
        if(buy) {
            return Math.max((-p[i] + dfs(i+1, p, false)), (0 + dfs(i+1,p, true)));
        }
        return Math.max((p[i] + dfs(i+2, p, true)), (0 + dfs(i+1, p, true)));
    }

    private int dfsMemo(int i, int[] p, int buy, int[][] dp) {
        if(i>=p.length) {
            return 0;
        }
        if(dp[i][buy]!=-1) {
            return dp[i][buy];
        }
        if(buy == 1) {
            return dp[i][buy] = Math.max((-p[i] + dfsMemo(i+1, p, 0, dp)), (0 + dfsMemo(i+1,p, 1, dp)));
        }
        return dp[i][buy] = Math.max((p[i] + dfsMemo(i+2, p, 1, dp)), (0 + dfsMemo(i+1, p, 0, dp)));
    }
}
