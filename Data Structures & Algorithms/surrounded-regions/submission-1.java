class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            dfsRegions(board, i, 0);
            dfsRegions(board, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            dfsRegions(board, 0, j);
            dfsRegions(board, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    private void dfsRegions(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
         || board[i][j] == '*' || board[i][j] == 'X') {
            return;
        }

        board[i][j] = '*';
        dfsRegions(board, i, j - 1);
        dfsRegions(board, i, j + 1);
        dfsRegions(board, i - 1, j);
        dfsRegions(board, i + 1, j);
    }
}
