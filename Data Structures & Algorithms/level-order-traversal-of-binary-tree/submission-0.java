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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(root,0));
         List<Integer> currNode = new ArrayList<>();
         int level=0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            TreeNode node=curr.node;
            int currLevel=curr.level;
            if(level!=currLevel){
                ans.add(currNode);
                currNode = new ArrayList<>();
                level++;
            }
            currNode.add(node.val);
            if(node.left!=null)pq.add(new Pair(node.left,currLevel+1));
             if(node.right!=null)pq.add(new Pair(node.right,currLevel+1));

           
        }
        ans.add(currNode);
        return ans;
    }
}
