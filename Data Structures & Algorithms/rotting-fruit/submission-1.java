class Solution {
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int t = 0;
        int fo = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fo++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fo == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != 1) {
                        continue;
                    }
                    grid[nx][ny] = 2; // remember to mark it 2 otherwise it will keep picking in each iteration and give infinite loop
                    queue.add(new int[]{nx, ny});
                    fo--;
                }
            }
            t++;
        }

        return fo == 0 ? t-1 : -1;

    }
}
