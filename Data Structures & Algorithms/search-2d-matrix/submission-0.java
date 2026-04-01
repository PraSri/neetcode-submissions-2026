class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++) {
            int rs = matrix[i][0];
            int re = matrix[i][m-1];
            if(target>=rs && target<=re) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        while(s<=e) {
            int mid = s + (e-s)/2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] > target) {
                e = mid-1;
            } else if(nums[mid] < target){
                s = mid + 1;
            }
        }
        return false;
    }
}
