class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        find(0, nums, ans, new ArrayList<>());
        return ans;
    }
    static void find(int idx, int arr[], List<List<Integer>> ans, ArrayList<Integer> curr) {
       
            ans.add(new ArrayList<>(curr));
        

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;

            curr.add(arr[i]);
            find(i + 1, arr, ans, curr);
            curr.remove(curr.size() - 1);
           
        }
    }
}
