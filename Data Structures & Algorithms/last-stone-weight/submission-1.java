class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones) {
            maxHeap.add(x);
        }
        while (!maxHeap.isEmpty()) {
            int x = maxHeap.poll();
            if (maxHeap.isEmpty()) {
                return x;
            } else {
                int y = maxHeap.poll();
                if (x != y) {
                    maxHeap.add(Math.abs(y - x));
                }
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.poll();
    }
}
