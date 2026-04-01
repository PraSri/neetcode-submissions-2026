class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) {
            return 0;
        }
        dp = new int[s.length() + 1][t.length() + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        // base case
        if(j>=t.length()) {
            return 1;
        }
        if(i>=s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = 0;
        if(s.charAt(i) == t.charAt(j)) {
            res = dfs(s, t, i+1, j) + dfs(s, t, i+1, j+1); // take or leave 
        } else {
            res = dfs(s, t, i+1, j); // leave
        }
        return dp[i][j] = res;
    }
}
