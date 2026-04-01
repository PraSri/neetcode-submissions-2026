class Solution {
    public int longestConsecutive(int[] nums) {
        // [2,20,4,10,3,4,5]
        //  it longest consecutive sequence not LIS
        // sort - [2,3,4,4,5,10,20] -> [2,3,4,5]
        // [0,3,2,5,4,6,1,1]
        // sort - [0,1,1,2,3,4,5,6] -> [0, 1, 2,3,4,5,6]
        // if i put all of them into a set and try searching num+1 in set
        // we should able to get the ans
        // nums=[9,1,4,7,3,-1,0,5,8,-1,6]
        // sort - [-1,-1,0,1,3,4,5,6,7,8,9]
        // set - [-1,0,1,3,4,5,6,7,8,9]
        // minNum = -1
        int n = nums.length;
        if(n<1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int x : nums) { 
            set.add(x);
        }
        
        int maxLen = 0;
        for(int x : set) {
            if(!set.contains(x - 1)) {
                int len = 1;
                while(set.contains(x + len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
