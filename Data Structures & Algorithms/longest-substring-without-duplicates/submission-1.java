class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(true)
        lengthOfLongestSubstringUsingHashMap(s);
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

    public int lengthOfLongestSubstringUsingHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for(int r = 0; r<s.length(); r++) {
            if(map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r))+1, l);
            }
            map.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
