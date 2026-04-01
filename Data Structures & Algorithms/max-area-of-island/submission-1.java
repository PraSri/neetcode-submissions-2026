class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        int[] area = {0};
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, n, m, area);
                    maxArea = Math.max(maxArea, area[0]);
                    area[0] = 0;
                }
            }
        }
        return maxArea;
    }
    
    private void dfs(int[][] grid, int i, int j, int n, int m, int[] area) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0) {
            return;
        }
        if(grid[i][j] == 1) {
            area[0]++;
        }
        grid[i][j] = 0;
        dfs(grid, i-1, j, n, m, area);
        dfs(grid, i, j-1, n, m, area);
        dfs(grid, i+1, j, n, m, area);
        dfs(grid, i, j+1, n, m, area);
    }
}
