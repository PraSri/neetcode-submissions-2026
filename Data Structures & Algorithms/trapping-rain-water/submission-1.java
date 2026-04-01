class Solution {
    public int trap(int[] height) {
          int n = height.length;

        // water cannot be trapped, it needs at least 3 bars
        if(n<=2)
            return 0;

        // 2 pointer approach
        int left = 0;
        int right = n-1;

        // track max from both sides
        int leftMax = height[left];
        int rightMax = height[right];

        int area = 0;

        while(left < right) {

            if(height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                area += leftMax - height[left];
            } else  {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                area += rightMax - height[right];
            }

        }

        return area;
    }
}
