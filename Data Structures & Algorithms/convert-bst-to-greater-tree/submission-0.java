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
    public TreeNode convertBST(TreeNode root) {
        
      int[] temp = {0};
        find(root, temp);
        return root;
    }

    static void find(TreeNode root, int[] temp) {
        if (root == null) return;

        find(root.right, temp);

        int original = root.val;
        root.val += temp[0];
        temp[0] += original;

        find(root.left, temp);
    }
}