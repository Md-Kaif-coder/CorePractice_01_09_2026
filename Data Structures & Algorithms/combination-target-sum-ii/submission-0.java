class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>  ans  = new ArrayList<>();
        find(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
    static void find(int idx,int arr[],int target,List<List<Integer>> ans,ArrayList<Integer> curr){
        
            if(target==0){
                ans.add(new ArrayList<>(curr));
                    return;
            }
        
        


        

        for(int i=idx;i<arr.length;i++){
              
            if(i>idx && arr[i]==arr[i-1])continue;
            
            if(target<arr[i])break;

          
            curr.add(arr[i]);
            find(i+1,arr,target-arr[i],ans,curr);
            curr.remove(curr.size()-1);
            
        }
        

    }
}
