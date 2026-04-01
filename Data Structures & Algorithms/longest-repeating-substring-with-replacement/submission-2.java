class Solution {
    public int characterReplacement(String s, int k) {
        // in window, which is mostFreq char 
        // try to make other char as mostFreq char
        // measure the max len and proceed
        // how big that window needs to be??

        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxf = 0;
        int n = s.length();
        for(int r = 0; r<n; r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));
            while((r-l+1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
