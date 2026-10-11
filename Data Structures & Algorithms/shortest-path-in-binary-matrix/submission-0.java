class Solution {
    class Pair {
        int row, col, dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n=grid.length;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
                return -1;

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

            pq.add(new Pair(0, 0, 1));
            int dist[][] = new int[grid.length][grid[0].length];
            for (int arr[] : dist) Arrays.fill(arr, Integer.MAX_VALUE);
            dist[0][0] = 1;
            while (!pq.isEmpty()) {
                Pair curr = pq.poll();

                int r = curr.row;
                int c = curr.col;
                int d = curr.dist;


                if (r == n - 1 && c == n - 1)
                    return d;

            
                if (r - 1 >= 0 && grid[r - 1][c] == 0 && d + 1 < dist[r - 1][c]) {
                    dist[r - 1][c] = d + 1;
                    pq.offer(new Pair(r - 1, c, d + 1));
                }

              
                if (r + 1 < n && grid[r + 1][c] == 0 && d + 1 < dist[r + 1][c]) {
                    dist[r + 1][c] = d + 1;
                    pq.offer(new Pair(r + 1, c, d + 1));
                }

           
                if (c - 1 >= 0 && grid[r][c - 1] == 0 && d + 1 < dist[r][c - 1]) {
                    dist[r][c - 1] = d + 1;
                    pq.offer(new Pair(r, c - 1, d + 1));
                }

           
                if (c + 1 < n && grid[r][c + 1] == 0 && d + 1 < dist[r][c + 1]) {
                    dist[r][c + 1] = d + 1;
                    pq.offer(new Pair(r, c + 1, d + 1));
                }

             
                if (r - 1 >= 0 && c - 1 >= 0 && grid[r - 1][c - 1] == 0
                    && d + 1 < dist[r - 1][c - 1]) {
                    dist[r - 1][c - 1] = d + 1;
                    pq.offer(new Pair(r - 1, c - 1, d + 1));
                }
                if (r - 1 >= 0 && c + 1 < n && grid[r - 1][c + 1] == 0
                    && d + 1 < dist[r - 1][c + 1]) {
                    dist[r - 1][c + 1] = d + 1;
                    pq.offer(new Pair(r - 1, c + 1, d + 1));
                }

               
                if (r + 1 < n && c - 1 >= 0 && grid[r + 1][c - 1] == 0
                    && d + 1 < dist[r + 1][c - 1]) {
                    dist[r + 1][c - 1] = d + 1;
                    pq.offer(new Pair(r + 1, c - 1, d + 1));
                }

                
                if (r + 1 < n && c + 1 < n && grid[r + 1][c + 1] == 0
                    && d + 1 < dist[r + 1][c + 1]) {
                    dist[r + 1][c + 1] = d + 1;
                    pq.offer(new Pair(r + 1, c + 1, d + 1));
                }
            }

            return -1;
        }
    }