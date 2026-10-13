class Solution {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int arr[]:edges){
            int u=arr[0];
            int v=arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[n];

        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(0,-1));
        visited[0]=true;

        while(pq.size()>0){
            Pair curr = pq.poll();

            int node=curr.node;
            int parent =curr.parent;


            for(int nei:adj.get(node)){
                if(!visited[nei]){
                    visited[nei]=true;
                    pq.add(new Pair(nei,node));
                }
                else if(visited[nei]==true && nei!=parent)return false;
            }

        }

        for(boolean el:visited){
            if(!el)return false;
        }

        return true;


    }
}
