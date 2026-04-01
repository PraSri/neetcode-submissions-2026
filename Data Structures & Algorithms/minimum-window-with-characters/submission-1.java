class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] f = new int[128];
        int l = 0;
        int r = 0;
        int counter = m;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (char c : t.toCharArray()) {
            f[c - 'A']++;
        }

        while (r < n) {
            if (f[s.charAt(r) - 'A'] > 0) {
                counter--;
            }
            f[s.charAt(r) - 'A']--;
            r++;
            while (counter == 0) {
                if (minLen > (r - l)) {
                    minLen = (r - l);
                    minStart = l;
                }
                f[s.charAt(l) - 'A']++;
                if (f[s.charAt(l) - 'A'] > 0) {
                    counter++;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    
    }
}
