class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    visited[i][j] = true;

                    boolean ans = find(board, i, j, word, 1, visited);

                    visited[i][j] = false;

                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean find(char[][] board, int i, int j,
                        String word, int idx,
                        boolean visited[][]) {

        // Word complete
        if (idx == word.length()) {
            return true;
        }

        // UP
        if (i > 0 &&
            !visited[i - 1][j] &&
            board[i - 1][j] == word.charAt(idx)) {

            visited[i - 1][j] = true;

            boolean ans = find(board, i - 1, j,
                               word, idx + 1, visited);

            visited[i - 1][j] = false;

            if (ans) {
                return true;
            }
        }

        // DOWN
        if (i + 1 < board.length &&
            !visited[i + 1][j] &&
            board[i + 1][j] == word.charAt(idx)) {

            visited[i + 1][j] = true;

            boolean ans = find(board, i + 1, j,
                               word, idx + 1, visited);

            visited[i + 1][j] = false;

            if (ans) {
                return true;
            }
        }

        // LEFT
        if (j > 0 &&
            !visited[i][j - 1] &&
            board[i][j - 1] == word.charAt(idx)) {

            visited[i][j - 1] = true;

            boolean ans = find(board, i, j - 1,
                               word, idx + 1, visited);

            visited[i][j - 1] = false;

            if (ans) {
                return true;
            }
        }

        // RIGHT
        if (j + 1 < board[0].length &&
            !visited[i][j + 1] &&
            board[i][j + 1] == word.charAt(idx)) {

            visited[i][j + 1] = true;

            boolean ans = find(board, i, j + 1,
                               word, idx + 1, visited);

            visited[i][j + 1] = false;

            if (ans) {
                return true;
            }
        }

        return false;
    }
}