class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            return nums;
        }
        int[] res = new int[n-k+1];
        Deque<Integer> window = new ArrayDeque<>();
        // process 1st k elements
        for(int i = 0; i < k; i++) {
            cleanUp(i, window, nums);
            window.add(i);
        }

        res[0] = nums[window.getFirst()];

        for(int i = k; i<n; i++) {
            cleanUp(i, window, nums);
            // contract window
            if(!window.isEmpty() && window.getFirst() <= (i-k)) {
                window.removeFirst();
            }
            window.add(i);
            res[i-k+1] = nums[window.getFirst()]; 
        }

        return res;
    }

    private void cleanUp(int i, Deque<Integer> window, int[] nums) {
        while(!window.isEmpty() && nums[i] >= nums[window.getLast()]) {
            window.removeLast();
        }
    }
}
