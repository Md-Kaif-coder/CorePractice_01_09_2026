class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        int sec=find(cost.length-2,cost,dp);
        int fir=find(cost.length-1,cost,dp);
        return Math.min(fir,sec);
        
    }
    static int find(int i,int arr[],int[]dp){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];


        return dp[i]=arr[i]+Math.min(find(i-1,arr,dp),find(i-2,arr,dp)); 
    }
}
