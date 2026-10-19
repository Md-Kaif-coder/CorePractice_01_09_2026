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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int flag[]={0};
         find(root,flag);
       return flag[0]!=1?true:false;
        
    }

    static int find(TreeNode root,int[]flag){
        if(root==null)return 0;
        int left = find(root.left,flag);
        int right =find(root.right,flag);
        if(Math.abs(left-right)>1)flag[0]=1;
        return 1+Math.max(left,right);
    }
}
