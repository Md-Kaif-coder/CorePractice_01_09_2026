class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int arr[]:dp)Arrays.fill(arr,-1);
        return find(prices,0,1,dp);
        
    }
    static int find(int arr[],int idx,int buy,int dp[][]){

            if(idx==arr.length)return 0;

            if(dp[idx][buy]!=-1)return dp[idx][buy];



        int profit = 0;

        if(buy==1){
            profit = Math.max(-arr[idx]+find(arr,idx+1,0,dp),0+find(arr,idx+1,1,dp));

        }
        else{
             profit = Math.max(arr[idx]+find(arr,idx+1,1,dp),0+find(arr,idx+1,0,dp));
        }
        return dp[idx][buy]=profit;
    }
}