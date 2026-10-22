
class Solution {
    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxAreaOfIsland(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(mat, i, j, visited);
                    ans = Math.max(ans, count);
                }
            }
        }

        return ans;
    }

    static int bfs(int mat[][], int i, int j, boolean visited[][]) {
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(i, j));
        visited[i][j] = true;

        int count = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            count++;

            if (row - 1 >= 0 && mat[row - 1][col] == 1 && !visited[row - 1][col]) {
                visited[row - 1][col] = true;
                pq.add(new Pair(row - 1, col));
            }

            if (row + 1 < mat.length && mat[row + 1][col] == 1 && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                pq.add(new Pair(row + 1, col));
            }

            if (col - 1 >= 0 && mat[row][col - 1] == 1 && !visited[row][col - 1]) {
                visited[row][col - 1] = true;
                pq.add(new Pair(row, col - 1));
            }

            if (col + 1 < mat[0].length && mat[row][col + 1] == 1 && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                pq.add(new Pair(row, col + 1));
            }
        }

        return count;
    }
}