class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<Character> output = new ArrayList<>();
        backtrack(n, 0, 0, result, output);
        return result;
    }

    private void backtrack(int n , int open, int close, 
                           List<String> result, List<Character> output) {
    
    // base case
    if(open >= n && close >= n) {
        String outputStr = output.toString(); // ex: "[(,),]"
        result.add(outputStr.substring(1, outputStr.length() - 1).replace(", ", ""));
    }

    // open is less than n
    if(open < n) {
        output.add('(');
        backtrack(n, open + 1, close, result, output);
        output.remove(output.size() - 1);
    }

    // close is less than open
    if(close < open) {
        output.add(')');
        backtrack(n, open, close + 1, result, output);
        output.remove(output.size() - 1);
    }

    }
}
