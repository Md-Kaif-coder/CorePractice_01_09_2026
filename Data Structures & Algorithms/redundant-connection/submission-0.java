class Solution {
    int[] parent;

    public int find(int node) {
        if (parent[node] == node)
            return node;

        int leader = find(parent[node]);
        parent[node] = leader;
        return leader;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return false;

        parent[pv] = pu;
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!union(u, v))
                return edge;
        }

        return new int[0];
    }
}
