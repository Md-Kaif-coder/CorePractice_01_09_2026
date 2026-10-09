class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for (int arr[] : dp) Arrays.fill(arr, -1);
        return find(grid, m - 1, n - 1, dp);
    }
    static int find(int arr[][], int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return arr[0][0];

        if (dp[i][j] != -1)
            return dp[i][j];

        int a = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            a = arr[i][j] + find(arr, i - 1, j, dp);
        }
        int b = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            b = arr[i][j] + find(arr, i, j - 1, dp);
        }

        return dp[i][j] = Math.min(a, b);
    }
}