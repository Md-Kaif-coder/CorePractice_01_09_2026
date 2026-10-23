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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null)
            return null;

        if (root.val == x.val || root.val == y.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, x, y);
        TreeNode right = lowestCommonAncestor(root.right, x, y);

        if (left != null && right != null)
            return root;

        return (left == null) ? right : left;
    }
}