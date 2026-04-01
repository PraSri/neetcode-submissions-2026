class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] f = new int[1000];
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int c = 0;
        while(end < n) {
            if(f[s.charAt(end)] > 0) {
                c++;
            }
            f[s.charAt(end)]++;
            end++;
            // contracts
            while(c > 0) {
                if(f[s.charAt(start)] > 1) {
                    c--;
                }
                f[s.charAt(start)]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);

        }
        return maxLen;
    }
}
