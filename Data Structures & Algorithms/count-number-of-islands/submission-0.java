

class Solution {
    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == '1' && !visited[i][j]) {
                    bfs(mat, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(char[][] mat, int i, int j, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            if (row - 1 >= 0 && mat[row - 1][col] == '1' && !visited[row - 1][col]) {
                visited[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }

            if (row + 1 < mat.length && mat[row + 1][col] == '1' && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }

            if (col - 1 >= 0 && mat[row][col - 1] == '1' && !visited[row][col - 1]) {
                visited[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }

            if (col + 1 < mat[0].length && mat[row][col + 1] == '1' && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }
        }
    }
}