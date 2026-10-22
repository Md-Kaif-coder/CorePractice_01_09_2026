class Solution {
    public int countCompleteComponents(int V, int[][] edges) {

   	List<Integer> curr = new ArrayList<>();
		
		
		
		List<List<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i<V; i++)adj.add(new ArrayList<>());
		
		for (int arr[] :edges) {
			int u = arr[0];
			int v = arr[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		int count = 0;
		
		boolean visited[] = new boolean[V];
		for (int i = 0; i<V; i++) {
			if (!visited[i]) {
				bfs(i, visited, adj,curr);
				boolean complete=true;

                for(int el:curr){
                    if(curr.size()-1!=adj.get(el).size())complete=false;
                }
                if(complete)count++;

                curr=new ArrayList<>();
			}
		}
		
		return count;
		
	}
	static void bfs(int i, boolean visited[], List<List<Integer>> adj,List<Integer> currList) {
		
		Queue<Integer> pq = new LinkedList<>();
		pq.add(i);
		
		visited[i] = true;
		
		while (pq.size()>0) {
			int curr = pq.poll();
			currList.add(curr);
			for (int nei:adj.get(curr)) {
				if (!visited[nei]) {
					visited[nei] = true;
					pq.add(nei);
				}
			}
		}
		
	}
}
