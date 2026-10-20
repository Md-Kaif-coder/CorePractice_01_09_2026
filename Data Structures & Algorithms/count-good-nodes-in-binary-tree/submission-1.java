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
    public int goodNodes(TreeNode root) {
        int pre = Integer.MIN_VALUE;
        int count[] = {0};
        find(root,count,pre);
        return count[0];
    }
    static void find(TreeNode root,int count[],int pre){
        if(root==null)return;
        if(root.val>=pre){
            pre=root.val;
            count[0]++;
        }
        find(root.left,count,pre);
        find(root.right,count,pre);
        

    }
}
