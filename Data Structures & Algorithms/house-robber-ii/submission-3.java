class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int a = find(0, n - 2, nums, dp1);
        int b = find(1, n - 1, nums, dp2);

        return Math.max(a, b);
    }

    static int find(int i, int j, int[] arr, int[] dp) {
        if (j < i) return 0;

        if (dp[j] != -1)
            return dp[j];

        int pick = arr[j] + find(i, j - 2, arr, dp);
        int skip = find(i, j - 1, arr, dp);

        return dp[j] = Math.max(pick, skip);
    }
}