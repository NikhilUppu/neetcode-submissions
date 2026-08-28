class Solution {
    int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    int n, m;
    
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && (i == 0 || i == n-1 || j == 0 || j == m-1)) {
                    capture(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void capture(char[][] board, int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= m || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for(int[] d : directions) {
            capture(board, r + d[0], c + d[1]);
        }
    }
}