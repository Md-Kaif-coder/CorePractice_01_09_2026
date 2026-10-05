class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int board[][] = new int[n][n];
        find(0,board,ans);
        return ans;
        
    }
    static void find(int row,int[][]board,List<List<String>>ans){
         if (row == board.length) {
            ArrayList<String> curr = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                StringBuilder s = new StringBuilder();

                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 1)
                        s.append('Q');
                    else
                        s.append('.');
                }

                curr.add(s.toString());
            }

            ans.add(curr);
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isValid(row,col,board)){
                board[row][col]=1;
                find(row+1,board,ans);
                board[row][col]=0;

            }
        }
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
