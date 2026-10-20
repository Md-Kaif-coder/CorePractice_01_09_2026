/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>  ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int level=0;
        while(pq.size()>0){
            List<Integer> res = new ArrayList<>();
            int size = pq.size();
            for(int i=0;i<size;i++){
                TreeNode curr = pq.poll();
               res.add(curr.val);
                if(curr.right!=null)pq.add(curr.right);
                if(curr.left!=null)pq.add(curr.left);
                
            }
            if(level%2==0){
                Collections.reverse(res);
                ans.add(res);
            }
            else{
                ans.add(res);
            }
            level++;
        }
        return ans;
        
    }
}