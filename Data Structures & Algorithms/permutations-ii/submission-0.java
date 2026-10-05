class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        find(0, nums, visited, ans, new ArrayList<>());
        return ans;
    }
    static void find(
        int idx, int arr[], boolean visited[], List<List<Integer>> ans, ArrayList<Integer> curr) {
        if (curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1] && visited[i-1] ) {
                continue;
            }

            curr.add(arr[i]);
            visited[i] = true;

            find(i+1,arr, visited, ans, curr);

            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
