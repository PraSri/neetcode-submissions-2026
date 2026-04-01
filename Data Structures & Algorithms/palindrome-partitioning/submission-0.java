class Solution {
   public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, 0, res, temp);
        return res;
    }

    private void dfs(String s, int start, List<List<String>> res, List<String> temp) {
        // base case, you reached the end of string
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // try every possible cut starting from `start`
        for (int end = start; end < s.length(); end++) {
            if (isPali(s, start, end)) {
                temp.add(s.substring(start, end + 1));
                dfs(s, end + 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int i, int j) {
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        return true;
    }
}
