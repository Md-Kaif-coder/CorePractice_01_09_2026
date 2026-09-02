class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int r = front.row;
            int c = front.col;

            // Left
            if (c - 1 >= 0 &&
                grid[r][c - 1] == Integer.MAX_VALUE) {

                grid[r][c - 1] = grid[r][c] + 1;
                q.add(new Pair(r, c - 1));
            }

            // Right
            if (c + 1 < n &&
                grid[r][c + 1] == Integer.MAX_VALUE) {

                grid[r][c + 1] = grid[r][c] + 1;
                q.add(new Pair(r, c + 1));
            }

            // Up
            if (r - 1 >= 0 &&
                grid[r - 1][c] == Integer.MAX_VALUE) {

                grid[r - 1][c] = grid[r][c] + 1;
                q.add(new Pair(r - 1, c));
            }

            // Down
            if (r + 1 < m &&
                grid[r + 1][c] == Integer.MAX_VALUE) {

                grid[r + 1][c] = grid[r][c] + 1;
                q.add(new Pair(r + 1, c));
            }
        }
    }
}