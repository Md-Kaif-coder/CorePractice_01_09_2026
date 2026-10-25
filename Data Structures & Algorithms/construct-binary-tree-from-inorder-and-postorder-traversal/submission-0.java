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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return constree(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    public TreeNode constree(
        int[] inorder, int inlo, int inhi, int[] postorder, int prelo, int prehi) {
        if (prelo > prehi || inlo > inhi)
            return null;

        int val = postorder[prehi];

        TreeNode root = new TreeNode(val);

        int r = 0;
        for (int i = inlo; i <= inhi; i++) {
            if (inorder[i] == val) {
                r = i;
                break;
            }
        }
        int count = inhi - r;

        root.left = constree(inorder, inlo, r - 1, postorder, prelo, prehi - count - 1);
        root.right = constree(inorder, r + 1, inhi, postorder, prehi - count, prehi - 1);
        return root;
    }
}