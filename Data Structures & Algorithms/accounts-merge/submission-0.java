class Solution {

    int[] parent;

    public int find(int node) {
        if (parent[node] == node)
            return node;

        int leader= find(parent[node]);
        parent[node]=leader;
        return leader;
    }

    public void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu != pv)
            parent[pv] = pu;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        // email -> account index
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1 : Build DSU
        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(i, map.get(email));
                }
            }
        }

        // Step 2 : Root -> Emails
        HashMap<Integer, List<String>> merged = new HashMap<>();

        for (String email : map.keySet()) {

            int accountIndex = map.get(email);

            int root = find(accountIndex);

            merged.putIfAbsent(root, new ArrayList<>());

            merged.get(root).add(email);
        }

        // Step 3 : Prepare Answer
        List<List<String>> ans = new ArrayList<>();

        for (int root : merged.keySet()) {

            List<String> emails = merged.get(root);

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(root).get(0)); // Name

            temp.addAll(emails);

            ans.add(temp);
        }

        return ans;
    }
}