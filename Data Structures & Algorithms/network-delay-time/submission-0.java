class Solution {
    class Pair{
        int node,dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.dist,b.dist);
        });
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int arr[]:times){
            int u=arr[0];
            int v = arr[1];
            int w = arr[2];
            adj.get(u-1).add(new Pair(v-1,w));
        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;

        pq.add(new Pair(k-1,0));

        while(!pq.isEmpty()){
            Pair  curr = pq.poll();
            int u=curr.node;
            int wt = curr.dist;

            for(Pair nei:adj.get(u)){
                int newDist = wt+nei.dist;
                if(newDist<dist[nei.node]){
                    dist[nei.node]=newDist;
                    pq.add(new Pair(nei.node,newDist));
                }
            }
        }
    int max = 0;

        for (int el : dist) {
            if (el == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, el);
        }

        return max;
        
    }
}
