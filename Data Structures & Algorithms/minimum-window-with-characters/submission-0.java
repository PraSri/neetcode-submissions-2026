class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int c = t.length();

        int[] f = new int[128];
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(char ch: t.toCharArray()) {
            f[ch - 'A']++;
        }

        while(end < n) {
            if(f[s.charAt(end) - 'A'] > 0) {
                c--;
            }
            f[s.charAt(end)-'A']--;
            end++; // expansion
            while(c==0) {
                // record stats
                if(minLen > (end - start)) {
                    minLen = end - start;
                    minStart = start;
                }
                // contraction is window
                char windowStart = s.charAt(start);
                f[windowStart - 'A']++;
                if(f[windowStart - 'A'] > 0) {
                    c++;
                }
                start++;
            }
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(minStart, minStart + minLen);
        
    }
}
