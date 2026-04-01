class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> lastSeen = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            // repeated char
            if (lastSeen.containsKey(s.charAt(r))) {
                int seenAt = lastSeen.get(s.charAt(r));
                l = Math.max(seenAt + 1, l);
            }
            lastSeen.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
