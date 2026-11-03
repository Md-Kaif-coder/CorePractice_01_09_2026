class Solution {
     class Trip{
        int row,col,wt;

        Trip(int row,int col,int wt){
            this.row=row;
            this.col=col;
            this.wt=wt;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Trip> pq =
            new PriorityQueue<>((a,b)->a.wt-b.wt);

        int[][] dist = new int[n][n];

        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];

        pq.add(new Trip(0,0,grid[0][0]));

        while(!pq.isEmpty()){

            Trip front = pq.poll();

            int r = front.row;
            int c = front.col;
            int wt = front.wt;

            if(r == n-1 && c == n-1){
                return wt;
            }

            // left
            if(c-1 >= 0){

                int newWt = Math.max(wt, grid[r][c-1]);

                if(newWt < dist[r][c-1]){

                    dist[r][c-1] = newWt;

                    pq.add(new Trip(r,c-1,newWt));
                }
            }

            // right
            if(c+1 < n){

                int newWt = Math.max(wt, grid[r][c+1]);

                if(newWt < dist[r][c+1]){

                    dist[r][c+1] = newWt;

                    pq.add(new Trip(r,c+1,newWt));
                }
            }

            // up
            if(r-1 >= 0){

                int newWt = Math.max(wt, grid[r-1][c]);

                if(newWt < dist[r-1][c]){

                    dist[r-1][c] = newWt;

                    pq.add(new Trip(r-1,c,newWt));
                }
            }

            // down
            if(r+1 < n){

                int newWt = Math.max(wt, grid[r+1][c]);

                if(newWt < dist[r+1][c]){

                    dist[r+1][c] = newWt;

                    pq.add(new Trip(r+1,c,newWt));
                }
            }
        }

        return -1;
    }
}