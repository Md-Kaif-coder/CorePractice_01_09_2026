class Solution {
    public int subsetXORSum(int[] nums) {
        
        return find(0,nums,0);
        
        
    }
    static int find(int i,int arr[],int xor){
        if(i>=arr.length)return xor;

        int pick = find(i+1,arr,arr[i]^xor);
        int skip = find(i+1,arr,xor);
        return pick+skip;
    }
}