class Solution {
    public int rob(int[] nums) {
        
        int dp [] = new int[nums.length];
        Arrays.fill(dp,-1);

        return find(nums.length-1,nums,dp);
        
    }
    static int find(int i,int arr[],int dp[]){
        if(i<0)return 0;

        if(dp[i]!=-1)return dp[i];


        int pick = arr[i]+find(i-2,arr,dp);
        int skip = 0 + find(i-1,arr,dp);
        return dp[i]=Math.max(pick,skip);
    }
}
