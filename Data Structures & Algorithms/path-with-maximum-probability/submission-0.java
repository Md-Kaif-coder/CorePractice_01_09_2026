class Solution {
    class Pair{
        int node;
        double wt;
        Pair(int node,double wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int dest) {
          List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p)); 
        }

        Queue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b.wt,a.wt);
        });

        double dist[] = new double[n];
         Arrays.fill(dist, 0.0);

         dist[src]=1.0;
         pq.add(new Pair(src,1.0));

         while(pq.size()>0){
            Pair curr=pq.poll();
            int node=curr.node;
            double prob=curr.wt;

            for(Pair nei:adj.get(node)){
                int v = nei.node;
                double neidist = nei.wt;
                double newProb = prob*neidist;
                if(newProb>dist[v]){
                    dist[v]=newProb;
                    pq.add(new Pair(v,newProb));
                }
            }
         }


        return dist[dest];
    }
}