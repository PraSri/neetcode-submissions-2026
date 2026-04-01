class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        while(s<e) {
            if(nums[s]<nums[e]) {
                return nums[s];
            }
            int mid = s + (e-s)/2;
            if(nums[mid]>=nums[s]) {
                s = mid+1;
            } else {
                e = mid;
            }
        }
        return nums[s];
    }
}
