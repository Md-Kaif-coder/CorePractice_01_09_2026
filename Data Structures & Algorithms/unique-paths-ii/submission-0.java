class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[m - 1][n - 1] == 1 || grid[0][0] == 1)
            return 0;

        int dp[][] = new int[m][n];

        for (int arr[] : dp) Arrays.fill(arr, -1);

        return find(grid, m - 1, n - 1, dp);
    }
    static int find(int arr[][], int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = 0;
        if (i - 1 >= 0 && arr[i - 1][j] != 1) {
            down = find(arr, i - 1, j, dp);
        }

        int left = 0;
        if (j - 1 >= 0 && arr[i][j - 1] != 1) {
            left = find(arr, i, j - 1, dp);
        }

        return dp[i][j] = down + left;
    }
};