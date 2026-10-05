class Solution {
  
    public int totalNQueens(int n) {
        int board[][] = new int[n][n];
        return find(0,board);
        
        
    }
    static int find(int row,int board[][]){
        if(row==board.length){
            return 1;
        }
        int ans =0;
        for(int col=0;col<board.length;col++){
            if(isValid(row,col,board)){
                board[row][col]=1;
                ans+=find(row+1,board);
                board[row][col]=0;
            }
        }
        return ans;
    }

    static boolean isValid(int row,int col,int[][]board){
        int i=row-1;
        int j=col-1;
        while(i>=0&&j>=0){
            if(board[i][j]==1)return false;
            i--;
            j--;
        }

        i=row-1;
        j=col+1;
        while(i>=0&&j<board.length){
            if(board[i][j]==1)return false;
            i--;
            j++;
        }
        i=row-1;
        j=col;
        while(i>=0){
            if(board[i][j]==1)return false;
            i--;
        }

        return true;

    }
}