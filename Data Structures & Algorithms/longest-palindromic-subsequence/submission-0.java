class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb= new StringBuilder(s);
        String s2=sb.reverse().toString();

        return longestCommonSubsequence(s,s2);

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1][n2];
        for(int arr[]:dp)
        Arrays.fill(arr,-1);

        return find(n1-1,n2-1,text1,text2,dp);
        
    }
    static int find(int i,int j,String s1,String s2,int dp[][]){
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+find(i-1,j-1,s1,s2,dp);
        }
        else {
            return dp[i][j]= Math.max(find(i-1,j,s1,s2,dp),find(i,j-1,s1,s2,dp));
        }
    }
}