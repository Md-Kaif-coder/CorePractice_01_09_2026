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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while(pq.size()>0){
            int size=pq.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currNode = pq.poll();
                int data=currNode.val;
                curr.add(data);
                if(currNode.left!=null)pq.add(currNode.left);
                if(currNode.right!=null)pq.add(currNode.right);

            }
            ans.add(curr);
        }
        return ans;

        
    }
}
