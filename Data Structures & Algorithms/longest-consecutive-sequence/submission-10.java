class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> lengthMap = new HashMap<>();
        int res = 0;

        for(int num: nums) {
            if(!lengthMap.containsKey(num)) {
                int leftLength = lengthMap.getOrDefault(num - 1, 0);
                int rightLength = lengthMap.getOrDefault(num + 1, 0);
                int length = leftLength + rightLength + 1;
                lengthMap.put(num, length);
                lengthMap.put(num - leftLength, length);
                lengthMap.put(num + rightLength, length);
                res = Math.max(res, length);
            }
        }

        // System.out.println(lengthMap);
        return res;
    }
}
