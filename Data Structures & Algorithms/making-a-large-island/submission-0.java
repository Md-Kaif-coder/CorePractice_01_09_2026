

class Solution {

    int[] parent;
    int[] size;

    public int find(int node) {

        if (parent[node] == node)
            return node;

        int leader = find(parent[node]);
        parent[node] = leader;

        return leader;
    }

    public void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        parent = new int[n * n];
        size = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Step 1: Connect existing land cells
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) {

                    int node = row * n + col;

                    // UP
                    if (row > 0 && grid[row - 1][col] == 1)
                        union(node, (row - 1) * n + col);

                    // DOWN
                    if (row < n - 1 && grid[row + 1][col] == 1)
                        union(node, (row + 1) * n + col);

                    // LEFT
                    if (col > 0 && grid[row][col - 1] == 1)
                        union(node, row * n + col - 1);

                    // RIGHT
                    if (col < n - 1 && grid[row][col + 1] == 1)
                        union(node, row * n + col + 1);
                }
            }
        }

        int maxArea = 0;

        // Step 2: Check every zero
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 0) {

                    HashSet<Integer> set = new HashSet<>();

                    // UP
                    if (row > 0 && grid[row - 1][col] == 1)
                        set.add(find((row - 1) * n + col));

                    // DOWN
                    if (row < n - 1 && grid[row + 1][col] == 1)
                        set.add(find((row + 1) * n + col));

                    // LEFT
                    if (col > 0 && grid[row][col - 1] == 1)
                        set.add(find(row * n + col - 1));

                    // RIGHT
                    if (col < n - 1 && grid[row][col + 1] == 1)
                        set.add(find(row * n + col + 1));

                    int area = 1;

                    // Add sizes of unique components
                    for (int leader : set) {
                        area += size[leader];
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        // Step 3: Handle all-ones grid
        for (int i = 0; i < n * n; i++) {

            if (parent[i] == i) {
                maxArea = Math.max(maxArea, size[i]);
            }
        }

        return maxArea;
    }
}
