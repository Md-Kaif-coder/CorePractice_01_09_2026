

class Solution {
    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int original = image[sr][sc];

        if (original == color) return image;

        boolean visited[][] = new boolean[m][n];

        bfs(image, sr, sc, visited, color, original);
        return image;
    }

    void bfs(int mat[][], int sr, int sc, boolean visited[][],
             int color, int original) {

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(sr, sc));
        visited[sr][sc] = true;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int row = curr.row;
            int col = curr.col;

            mat[row][col] = color;

            
            if (row - 1 >= 0 && !visited[row - 1][col]
                    && mat[row - 1][col] == original) {
                visited[row - 1][col] = true;
                pq.add(new Pair(row - 1, col));
            }

           
            if (row + 1 < mat.length && !visited[row + 1][col]
                    && mat[row + 1][col] == original) {
                visited[row + 1][col] = true;
                pq.add(new Pair(row + 1, col));
            }

           
            if (col - 1 >= 0 && !visited[row][col - 1]
                    && mat[row][col - 1] == original) {
                visited[row][col - 1] = true;
                pq.add(new Pair(row, col - 1));
            }

            
            if (col + 1 < mat[0].length && !visited[row][col + 1]
                    && mat[row][col + 1] == original) {
                visited[row][col + 1] = true;
                pq.add(new Pair(row, col + 1));
            }
        }
    }
}