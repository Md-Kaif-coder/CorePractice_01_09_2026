class Solution {
    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;

        }
    }
    public int orangesRotting(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int two=0;
        Queue<Pair> pq = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    two++;
                    pq.add(new Pair(i,j));
                }
            }
        }

        

        int count=0;
        while(pq.size()>0){
            int size=pq.size();
            count++;
            for(int i=0;i<size;i++){
                Pair curr=pq.poll();
                int row=curr.row;
                int col=curr.col;

                if(row-1>=0 && grid[row-1][col]==1){
                    pq.add(new Pair(row-1,col));
                    grid[row-1][col]=2;
                }
                if(row+1<m && grid[row+1][col]==1){
                    pq.add(new Pair(row+1,col));
                    grid[row+1][col]=2;
                }
                if(col-1>=0 && grid[row][col-1]==1){
                    pq.add(new Pair(row,col-1));
                    grid[row][col-1]=2;
                }
                if(col+1<n && grid[row][col+1]==1){
                    pq.add(new Pair(row,col+1));
                    grid[row][col+1]=2;
                }
                
            }

        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)return -1;
            }
        }

        if(two==0)return 0;
        return count-1;
        
    }
}
