
class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for (int el : arr) sum += el;

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] dp = new Boolean[arr.length][target + 1];

        return find(arr, 0, target, dp);
    }

    static boolean find(int[] arr, int i, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == arr.length) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean pick = false;

        if (arr[i] <= target) {
            pick = find(arr, i + 1, target - arr[i], dp);
        }

        boolean skip = find(arr, i + 1, target, dp);

        return dp[i][target] = pick || skip;
    }
}
