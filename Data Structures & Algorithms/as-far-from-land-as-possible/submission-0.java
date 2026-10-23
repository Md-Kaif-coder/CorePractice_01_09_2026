class Solution {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        int land = 0;

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    land++;
                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }

        
        if (land == 0 || land == m * n) {
            return -1;
        }

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int r = front.row;
            int c = front.col;

       
            if (c - 1 >= 0 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                grid[r][c - 1] = grid[r][c] + 1;
                q.add(new Pair(r, c - 1));
            }

            if (c + 1 < n && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                grid[r][c + 1] = grid[r][c] + 1;
                q.add(new Pair(r, c + 1));
            }

         
            if (r - 1 >= 0 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                grid[r - 1][c] = grid[r][c] + 1;
                q.add(new Pair(r - 1, c));
            }

          
            if (r + 1 < m && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                grid[r + 1][c] = grid[r][c] + 1;
                q.add(new Pair(r + 1, c));
            }
        }

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max - 1;
    }
}