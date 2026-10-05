class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        find(0,arr,ans,new ArrayList<>(),k);
        return ans;
        
    }
    static void find(int idx,int arr[],List<List<Integer>> ans,ArrayList<Integer> curr,int k){

        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            curr.add(arr[i]);
            find(i+1,arr,ans,curr,k);
            curr.remove(curr.size()-1);

        }
    }
}