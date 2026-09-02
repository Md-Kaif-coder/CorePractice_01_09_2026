class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2*n];
    
        for(int i=0;i<2*n;i++){
            if(i>n-1){
                ans[i]=nums[i-n];
            }
            else{
                ans[i]=nums[i];
            }
        }
        return ans;
        
    }
}