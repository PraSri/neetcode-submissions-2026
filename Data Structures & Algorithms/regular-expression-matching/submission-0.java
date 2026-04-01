class Solution {
    private Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        dp = new Boolean[n+1][m+1];
        return dfs(0, 0, s, p, n, m);
    }

    private Boolean dfs(int i, int j, String s, String p, int n, int m) {
        if(j == m) {
            return i == n;
        }

        if(dp[i][j]!=null) {
            return dp[i][j];
        }

        boolean match = i<n && (s.charAt(i)==p.charAt(j) || p.charAt(j) == '.');

        if(j+1<m && p.charAt(j+1) == '*') {
            dp[i][j] = dfs(i, j+2, s, p, n, m) || (match && dfs(i+1,j,s,p,n,m));
        } else {
            dp[i][j] = match && dfs(i+1, j+1, s, p, n, m);
        }
        return dp[i][j];
    }
}
