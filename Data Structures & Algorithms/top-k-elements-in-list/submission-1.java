class Solution {
    class Pair{
        int el;
        int freq;
        Pair(int el,int freq){
            this.el = el;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        Arrays.sort(nums);

        int t = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[t]){
                pq.add(new Pair(nums[t],i-t));
                t=i;
            }
          if(i==nums.length-1)
            pq.add(new Pair(nums[t],i-t+1));
        }

     int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().el;

        }
        return ans;

        
    }
}
