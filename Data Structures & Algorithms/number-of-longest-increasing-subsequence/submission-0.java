class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int dp[] = new int[n];
        int count[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }

        return ans;
    }
}