class Solution {
    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && !visited[0][i]) {
                visited[0][i] = true;
                q.add(new Pair(0, i));
            }
            if (grid[m - 1][i] == 1 && !visited[m - 1][i]) {
                visited[m - 1][i] = true;
                q.add(new Pair(m - 1, i));
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                visited[i][0] = true;
                q.add(new Pair(i, 0));
            }
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                visited[i][n - 1] = true;
                q.add(new Pair(i, n - 1));
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row, c = p.col;

            if (c > 0 && grid[r][c - 1] == 1 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                q.add(new Pair(r, c - 1));
            }

            if (c + 1 < n && grid[r][c + 1] == 1 && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                q.add(new Pair(r, c + 1));
            }

            if (r > 0 && grid[r - 1][c] == 1 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                q.add(new Pair(r - 1, c));
            }

            if (r + 1 < m && grid[r + 1][c] == 1 && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                q.add(new Pair(r + 1, c));
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && !visited[i][j])
                    count++;

        return count;
    }
}