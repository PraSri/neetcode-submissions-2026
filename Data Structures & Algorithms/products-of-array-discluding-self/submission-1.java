class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(true) {
            return productExceptSelf_optimized(nums);
        }
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        int[] suff = new int[n];
        suff[n-1] = 1;
        int[] res = new int[n];
        for(int i = 1;i<n;i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }
        for(int i = n-2;i>=0;i--){
            suff[i] = suff[i+1] * nums[i+1];
        }
        for(int i = 0;i<n;i++) {
            res[i] = pre[i] * suff[i];
        }
        return res;
    }

public int[] productExceptSelf_optimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1;i<n;i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int postfix = 1;
        for(int i = n-1;i>=0;i--) {
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }
        return res;
    }

}  
