class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n<=2)
        return 0;
        int left = 0;
        int right = n-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int area = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[++left]);
                area += leftMax - height[left];
            } else  {
                rightMax = Math.max(rightMax, height[--right]);
                area += rightMax - height[right];
            }
        }
        return area;
    }
}
