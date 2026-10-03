class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ans=new ArrayList<>();
         find(0,nums,ans,new ArrayList<>());
         return ans;
        
    }
    static void find(int i,int[] arr,List<List<Integer>>ans,ArrayList<Integer>curr){
        
        if(i>=arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[i]);

        find(i+1,arr,ans,curr);
        curr.remove(curr.size()-1);
        find(i+1,arr,ans,curr);
    }
}
