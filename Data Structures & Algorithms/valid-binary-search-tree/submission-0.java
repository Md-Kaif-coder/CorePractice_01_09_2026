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
     class Triplet {
        long max;
        long min;
        boolean isBST;

        Triplet(long max, long min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root).isBST;
    }

    public Triplet solve(TreeNode root) {
        // Base Case: Empty node is a BST
        if (root == null) {
            // Hum Long use kar rahe hain taaki Integer.MIN_VALUE/MAX_VALUE ki edge cases handle ho sakein
            return new Triplet(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }

        Triplet lst = solve(root.left);
        Triplet rst = solve(root.right);

        // Current node ki values update karo
        long currentMax = Math.max((long)root.val, Math.max(lst.max, rst.max));
        long currentMin = Math.min((long)root.val, Math.min(lst.min, rst.min));

        // BST ki condition check karo
        // 1. Left subtree BST hona chahiye
        // 2. Right subtree BST hona chahiye
        // 3. Left ka max root se chota hona chahiye
        // 4. Right ka min root se bada hona chahiye
        boolean isBST = lst.isBST && rst.isBST && (lst.max < root.val) && (rst.min > root.val);

        return new Triplet(currentMax, currentMin, isBST);
    }
}