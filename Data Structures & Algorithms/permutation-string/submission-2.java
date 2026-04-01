class Solution {
    public boolean checkInclusion(String s1, String s2) {
         int n = s1.length();
        int m = s2.length();

        if (m < n) {
            return false;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (int i = 0; i < n; i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (f1[i] == f2[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < m; r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            f2[index]++;
            if (f2[index] == f1[index]) {
                matches++;
            } else if (f1[index] + 1 == f2[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            f2[index]--;
            if (f1[index] == f2[index]) {
                matches++;
            } else if (f1[index] - 1 == f2[index]) {
                matches--;
            }
            l++;
        }

        return matches == 26;

    }
}
