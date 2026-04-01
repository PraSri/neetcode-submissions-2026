class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.getOrDefault(s.charAt(r), 0));
            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
