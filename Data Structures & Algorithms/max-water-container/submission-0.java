class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n - 1;
        int res = Integer.MIN_VALUE;
        while(l<r) {
            res = Math.max(res, (r-l)*Math.min(heights[l], heights[r]));
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
