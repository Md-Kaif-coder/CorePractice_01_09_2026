class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int el:nums)sum+=el;

        int dp[][] = new int[nums.length][2*sum+1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
          if (Math.abs(target) > sum) return 0;

        return find(nums.length - 1, nums, target, dp,sum);
    }
    static int find(int i, int arr[], int target, int dp[][],int off) {
          if (Math.abs(target) > off) return 0;
        if (i < 0) {
            if (target == 0)
                return 1;
            return 0;
        }
        if (dp[i][target+off] != -1)
            return dp[i][target+off];
        int pick = find(i - 1, arr, target - arr[i], dp,off);
        int skip = find(i - 1, arr, target + arr[i], dp,off);
        return dp[i][target+off]= pick + skip;
    }
}
