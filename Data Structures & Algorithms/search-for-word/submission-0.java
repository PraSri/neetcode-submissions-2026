class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if(word.length() == idx) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        // boundary cases
        if(i<0 || j<0 || i>=n || j>=m || 
        board[i][j] != word.charAt(idx) || board[i][j] == '#') {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        // explore all dfs
        boolean res = dfs(board, word, i-1,j,idx+1) || 
        dfs(board, word, i+1, j, idx+1) || 
        dfs(board, word, i, j-1, idx+1) || 
        dfs(board, word, i, j+1, idx+1);
        // backtrack
        board[i][j] = temp;
        return res;
    }
}
