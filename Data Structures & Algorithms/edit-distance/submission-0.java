class Solution {
    int n,m;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(word1, word2, 0, 0);
    }
    private int dfs(String s1, String s2, int i , int j) {
        if(i == n) {
            return m - j;
        }
        if(j == m) {
            return n - i;
        }
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = dfs(s1, s2, i+1, j+1);
        } else {
            int insert = dfs(s1, s2, i+1, j);
            int delete = dfs(s1, s2, i, j+1);
            int replace = dfs(s1, s2, i+1, j+1);
            dp[i][j] = 1 + Math.min(Math.min(insert, delete), replace);
        }
        return dp[i][j];
    }
}
