class Solution {
    // initialize visited boolean 2D array
    // min heap on int[] sorted on 0th index
    // each element of min heap will be {grid value, row index, col index}
    // add 0th grid element in heap, mark it visited 
    // loop on heap till its empty
    // pop one element from heap
    // if its row & col reaches end of grid, 
    // return grid value (0th index of heap element)
    // else iterate in all 4 directions
    // add in queue if valid conditions 
    // mark each new node visited and add in heap
    // heap 0th index - value is max of curr value or new node value
    // if loop ends, return N*N
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}}; 
        pq.add(new Node(0, 0, grid[0][0]));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int time = node.time;
            if(x == n-1 && y == n-1) {
                return time;
            }
            for(int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                pq.offer(new Node(nx, ny, Math.max(time, grid[nx][ny])));
            }
        }
        return n*n;
    }

    public static class Node {
        int x, y, time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
