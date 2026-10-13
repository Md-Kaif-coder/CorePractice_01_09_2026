class Solution {
    public int[] findOrder(int V, int[][] edges) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        int indeg[]=new int[V];
        for(int arr[]:edges){
            int u=arr[0];
            int v=arr[1];
            indeg[v]++;
            adj.get(u).add(v);
        }
        ArrayList<Integer> ans=new ArrayList<>();

        Queue<Integer> pq = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0)pq.add(i);
        }
        int count=0;

        while(pq.size()>0){
            int curr = pq.poll();
            ans.add(curr);
             count++;
            for(int nei:adj.get(curr)){
                indeg[nei]--;
                if(indeg[nei]==0)pq.add(nei);
            }
        }
        Collections.reverse(ans);
        if(count!=V)return new int[0];
        int res[] = new int[V];
        for(int i=0;i<V;i++)res[i]=ans.get(i);
        return res;
        
    }
}
