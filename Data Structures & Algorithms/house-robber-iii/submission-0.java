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
   static class Pair{
        int pick,skip;
        Pair(int pick,int skip){
            this.pick=pick;
            this.skip = skip;

        }
    }
    public int rob(TreeNode root) {
       
       Pair ans = find(root);

       return Math.max(ans.pick,ans.skip);
       


    }
    static Pair find(TreeNode root){
        if(root==null)return new Pair(0,0);
        if(root.left==null&&root.right==null){
            return new Pair(root.val,0);
        }

        Pair left = find(root.left);
        Pair right = find(root.right);

        int take = root.val+ left.skip+right.skip;
        int skip =Math.max(left.pick,left.skip)+Math.max(right.pick,right.skip);
        return new Pair(take,skip);

    }
}