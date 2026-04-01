class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if(queue.isEmpty()) {
            return;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != 2147483647) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                grid[nx][ny] = grid[curr[0]][curr[1]] + 1;
            }
        }
    }
}
