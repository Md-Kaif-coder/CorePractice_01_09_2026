class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            bfs(heights, 0, i, pacific);
            bfs(heights, m - 1, i, atlantic);
        }

        for (int i = 0; i < m; i++) {
            bfs(heights, i, 0, pacific);
            bfs(heights, i, n - 1, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    void bfs(int[][] h, int i, int j, boolean[][] visited) {
        int m = h.length, n = h[0].length;
        Queue<Pair> q = new LinkedList<>();

        if (visited[i][j]) return;

        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.row, c = p.col;

            if (c > 0 && !visited[r][c - 1] && h[r][c - 1] >= h[r][c]) {
                visited[r][c - 1] = true;
                q.add(new Pair(r, c - 1));
            }

            if (c + 1 < n && !visited[r][c + 1] && h[r][c + 1] >= h[r][c]) {
                visited[r][c + 1] = true;
                q.add(new Pair(r, c + 1));
            }

            if (r > 0 && !visited[r - 1][c] && h[r - 1][c] >= h[r][c]) {
                visited[r - 1][c] = true;
                q.add(new Pair(r - 1, c));
            }

            if (r + 1 < m && !visited[r + 1][c] && h[r + 1][c] >= h[r][c]) {
                visited[r + 1][c] = true;
                q.add(new Pair(r + 1, c));
            }
        }
    }
}