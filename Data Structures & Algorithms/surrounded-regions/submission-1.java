class Solution {

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                visited[0][j] = true;
                q.add(new Pair(0, j));
            }

            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                visited[m - 1][j] = true;
                q.add(new Pair(m - 1, j));
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                visited[i][0] = true;
                q.add(new Pair(i, 0));
            }

            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                visited[i][n - 1] = true;
                q.add(new Pair(i, n - 1));
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row, c = p.col;

            if (c > 0 && board[r][c - 1] == 'O' && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                q.add(new Pair(r, c - 1));
            }

            if (c + 1 < n && board[r][c + 1] == 'O' && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                q.add(new Pair(r, c + 1));
            }

            if (r > 0 && board[r - 1][c] == 'O' && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                q.add(new Pair(r - 1, c));
            }

            if (r + 1 < m && board[r + 1][c] == 'O' && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                q.add(new Pair(r + 1, c));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}