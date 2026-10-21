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
    public int diameterOfBinaryTree(TreeNode root) {
        int max[]={0};
        find(root,max);
        return max[0];
        
    }
    static int find(TreeNode root,int max[]){
        if(root==null)return 0;
       // if(root.left==null&&root.right==null)return 1;
        int left = find(root.left,max);
        int right=find(root.right,max);

        max[0]=Math.max(left+right,max[0]);
        return 1+Math.max(left,right);
    }
}
