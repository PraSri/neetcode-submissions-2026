class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[100];
        for(char ch: s.toCharArray()) {
            frequency[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            frequency[ch - 'a']--;
        }
        for(int i = 0;i<100;i++) {
            if(frequency[i]!=0) {
                return false;
            }
        }
        return true;
    }
}
