class Solution {
    public int lengthOfLIS(int[] arr) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                    max=Math.max(dp[i],max);
                }
            }
        }
        return max;
        
    }
}
