class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)adj.add(new ArrayList<>());
        for(int arr[]:edges){
            int u = arr[0];
            int v =arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count=0;

    boolean visited[] = new boolean[n];
    for(int i=0;i<n;i++){
        if(!visited[i]){
            bfs(i,visited,adj);
            count++;
        }
    }
    return count;

    }
    static void bfs(int node, boolean visited[],List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node]=true;

       while(!q.isEmpty()){
        int curr = q.poll();
        for(int nei:adj.get(curr)){
            if(!visited[nei]){
                visited[nei] = true;
                q.add(nei);
            }
        }

       }
    }
}
