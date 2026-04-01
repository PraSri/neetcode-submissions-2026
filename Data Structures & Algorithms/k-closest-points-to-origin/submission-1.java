class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x.d));
        for (int[] point : points) {
           minHeap.offer(new Point(point[0], point[1]));
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!minHeap.isEmpty() && k >0) {
            Point point = minHeap.poll();
            res[i][0] = point.x;
            res[i][1] = point.y;
            i++;
            k--;
        }
        return res;

    }

    static class Point {
        int x, y, d;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = x * x + y * y;
        }
    }
}
