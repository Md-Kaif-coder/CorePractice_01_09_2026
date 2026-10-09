class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
     int n = triangle.size();
        int dp[][] = new int[n][n];

        for (int arr[] : dp)
            Arrays.fill(arr, Integer.MIN_VALUE);

        return find(triangle, 0, 0, dp);

    }

    static int find(List<List<Integer>> triangle, int i, int j, int [][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];

        int a = triangle.get(i).get(j) + find(triangle, i + 1, j, dp);
        int b = triangle.get(i).get(j) + find(triangle, i + 1, j + 1, dp);
       
        return dp[i][j] = Math.min(a,b);
    }
}