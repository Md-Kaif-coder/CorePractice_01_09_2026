class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int arr[] : dp) Arrays.fill(arr, -1);

        return find(m, n, dp);
    }
    static int find(int i, int j, int dp[][]) {
        if (i == 1 || j == 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = find(i - 1, j, dp);
        int left = find(i, j - 1, dp);
        return dp[i][j] = down + left;
    }
}