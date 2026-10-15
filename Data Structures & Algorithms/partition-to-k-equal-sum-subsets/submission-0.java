class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0 ;
        for(int el:nums)sum+=el;
        if(sum%k!=0)return false;
        int target=sum/k;
        if(nums[nums.length-1]>target)return false;

        int sides[] = new int[k];

        return find(nums,nums.length-1,sides,target);
        
    }
    static boolean find(int arr[],int i,int sides[],int target){
        if(i<0){
            for(int k=0;k<sides.length;k++){
                if(sides[k]!=target)return false;
            }
            return true;
        }

        for(int j=0;j<sides.length;j++){
            if(sides[j]+arr[i]<=target){
                sides[j]+=arr[i];


                if(find(arr,i-1,sides,target))return true;

                sides[j]-=arr[i];
            }
        }
        return false;
    }
}