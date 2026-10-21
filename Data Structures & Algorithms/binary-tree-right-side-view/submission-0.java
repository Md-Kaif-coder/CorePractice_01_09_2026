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
    static class Pair {
        int level;
        TreeNode node;

        Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        int currLevel = 0;
        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(0, root));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int level = curr.level;
            TreeNode node = curr.node;

            if (currLevel == level) {
                ans.add(node.val);
                currLevel++;
            }

            if (node.right != null)
                pq.add(new Pair(level + 1, node.right));

            if (node.left != null)
                pq.add(new Pair(level + 1, node.left));
        }
        return ans;
    }
}