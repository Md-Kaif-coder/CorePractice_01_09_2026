class Solution {
    public boolean canFinish(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        int indeg[]=new int[V];
        for(int arr[]:edges){
            int u=arr[0];
            int v=arr[1];
            indeg[v]++;
            adj.get(u).add(v);
        }

        Queue<Integer> pq = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0)pq.add(i);
        }
        int count=0;

        while(pq.size()>0){
            int curr = pq.poll();
            count++;
            for(int nei:adj.get(curr)){
                indeg[nei]--;
                if(indeg[nei]==0)pq.add(nei);
            }
        }
        return count==V;
        
    }
}
