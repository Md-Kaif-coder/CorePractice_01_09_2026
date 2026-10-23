class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        int r = grid2.length;
        int c = grid2[0].length;

        boolean visited[][] = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    // flag=true;

                    if (bfs(grid2, i, j, visited, grid1))
                        count++;
                }
            }
        }

        return count;
    }
    boolean bfs(int[][] grid2, int i, int j, boolean visited[][], int[][] grid1) {
        boolean flag = true;
        Queue<Pair> q = new LinkedList<>();
        int m = grid2.length;
        int n = grid2[0].length;
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pair front = q.remove();
            int r = front.row;
            int c = front.col;

            if (grid1[r][c] != 1) {
                flag = false;
            }

            if (c - 1 >= 0 && !visited[r][c - 1] && grid2[r][c - 1] == 1) {
                visited[r][c - 1] = true;
                q.add(new Pair(r, c - 1));
            }

            if (c + 1 < n && !visited[r][c + 1] && grid2[r][c + 1] == 1) {
                visited[r][c + 1] = true;
                q.add(new Pair(r, c + 1));
            }
            if (r - 1 >= 0 && !visited[r - 1][c] && grid2[r - 1][c] == 1) {
                visited[r - 1][c] = true;
                q.add(new Pair(r - 1, c));
            }

            if (r + 1 < m && !visited[r + 1][c] && grid2[r + 1][c] == 1) {
                visited[r + 1][c] = true;
                q.add(new Pair(r + 1, c));
            }
            
        }
        return flag;
    }
}