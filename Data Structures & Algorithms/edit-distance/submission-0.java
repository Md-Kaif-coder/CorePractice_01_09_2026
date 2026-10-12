class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        return find(n - 1, m - 1, word1, word2, dp);
    }

    static int find(int i, int j, String s1, String s2, int dp[][]) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = find(i - 1, j - 1, s1, s2, dp);

        int insert = find(i, j - 1, s1, s2, dp);
        int delete = find(i - 1, j, s1, s2, dp);
        int replace = find(i - 1, j - 1, s1, s2, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}