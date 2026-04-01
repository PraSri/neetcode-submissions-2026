class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[s] <= nums[mid]) {
                // this part is sorted
                if(target > nums[mid] || target < nums[s]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                // search in this part
                if(target < nums[mid] || target > nums[e]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
