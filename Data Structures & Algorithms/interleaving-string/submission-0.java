class Solution {
    int n, m, N;
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        N = s3.length();
        if(n + m != N) {
            return false;
        }
        dp = new Boolean[n+1][m+1];
        return dfs(0, 0, s1, s2,s3);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3) {
        if(i>=n && j>=m && i+j>=N) {
            return true;
        }
        if(i+j >= N) {
            return false;
        }
        if(dp[i][j]!=null) {
            return dp[i][j];
        }
        boolean result = false;
        if(i<n && s1.charAt(i)==s3.charAt(i+j)) {
           result = dfs(i+1, j, s1,s2,s3);
        }
        if(result) {
            return dp[i][j] = result;
        }
        if(j<m && s2.charAt(j)==s3.charAt(i+j)) {
            result = dfs(i, j+1, s1,s2,s3);
        }
        return dp[i][j] = result;
    }
}
