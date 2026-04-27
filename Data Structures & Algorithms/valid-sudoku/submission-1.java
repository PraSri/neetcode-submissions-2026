class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!set.add(ch + " add row - " + i) || !set.add(ch + " add col - " + j) || !set.add(ch + " add block - " + i / 3 + "_" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
