class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] f = new int[26];
        for(char c: s1.toCharArray()) {
            f[c - 'a']++;
        }
        for(int i =0;i<=n2-n1;i++) {
            int[] c = new int[26];
            for(int j = 0;j<n1;j++) {
                c[s2.charAt(i+j)-'a']++;
            }
            if(match(f,c)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(int[] f, int[] c) {
        int i = 0;
        for(int x: f) {
            if(x!=c[i++]) {
                return false;
            }
        }
        return true;
    }
}
