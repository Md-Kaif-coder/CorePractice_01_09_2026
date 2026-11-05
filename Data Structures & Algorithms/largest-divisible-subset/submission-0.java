class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
     Arrays.sort(arr);

       List<Integer> ans = new ArrayList<>();
        
        int n = arr.length;
    
        if (n == 0) return ans;

        int max = 0;

        int dp[] = new int[n];

        Arrays.fill(dp, 1);

        int hash[] = new int[n];
        for (int i = 0; i < n; i++) hash[i] = i;

        for (int i = 0; i<n; i++) {
            for (int j =0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }

            if (dp[i] > dp[max]) {
                max = i;
            }
        }

        int i = max;
        while (i != hash[i]) {
            ans.add(arr[i]);
            i = hash[i];
        }

        ans.add(arr[i]);
        Collections.reverse(ans);
        return ans;
    }
}