class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int newTarget = (total - target)/2;
        if((total - target) < 0 || (total - target)%2==1) {
            return 0;
        }
        int[][] dp = new int[nums.length+1][newTarget + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return waysMemo(nums.length-1, nums, newTarget, dp);
    }

    private int ways(int i, int[] nums, int target) {
        if(i==0) {
            if(target == 0 && nums[0] == 0) {
                return 2;
            }
            if(target == 0 || target == nums[0]) {
                return 1;
            }
            return 0;
        }
        int notTaken = ways(i-1, nums, target);
        int taken = 0;
        if(nums[i]<=target) {
            taken = ways(i-1, nums, target - nums[i]);
        }
        return notTaken + taken;
    }

    private int waysMemo(int i, int[] nums, int target, int[][] dp) {
        if(i==0) {
            if(target == 0 && nums[0] == 0) {
                return 2;
            }
            if(target == 0 || target == nums[0]) {
                return 1;
            }
            return 0;
        }
        if(dp[i][target]!=-1) {
            return dp[i][target];
        }
        int notTaken = waysMemo(i-1, nums, target, dp);
        int taken = 0;
        if(nums[i]<=target) {
            taken = waysMemo(i-1, nums, target - nums[i], dp);
        }
        return dp[i][target] = notTaken + taken;
    }
}
