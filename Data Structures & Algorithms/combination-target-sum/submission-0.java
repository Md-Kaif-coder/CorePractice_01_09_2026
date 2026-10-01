class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>>  ans = new ArrayList<>();
        find(0,nums,target,0,ans,new ArrayList<>());
        return ans;
        
    }
    static void find(int i,int arr[], int target,int sum,List<List<Integer>> ans,ArrayList<Integer> curr){
        if(i==arr.length)return;

        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(sum>target)return;

        curr.add(arr[i]);
        find(i,arr,target,sum+arr[i],ans,curr);
        curr.remove(curr.size()-1);
        find(i+1,arr,target,sum,ans,curr);


    }
}
