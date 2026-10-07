class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=prices.length-1;i>=0;i--){
            int buy = find(prices,0,i-1);
            max = Math.max(max,prices[i]-buy);
        }
        return max;
    }
    static int find(int arr[],int i,int j){
        int min=arr[0];
        for(int k=0;k<=j;k++)min=Math.min(min,arr[k]);
        return min;
    }

}
