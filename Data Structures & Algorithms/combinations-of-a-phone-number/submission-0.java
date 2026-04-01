class Solution {
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
        return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(res, digits, 0, "");
        return res;
    }

    private void helper(List<String> res, String digits, int i, String temp) {
        if(i>=digits.length()) {
            res.add(temp);
            return;
        }
        
        String curr = map.get(digits.charAt(i));

        for(int j = 0;j<curr.length();j++) {
            helper(res, digits, i + 1, temp + curr.charAt(j));
        }

    }
}
