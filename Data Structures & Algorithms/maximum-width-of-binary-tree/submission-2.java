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
    class Pair {
        long level;
        TreeNode node;

        Pair(long level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int max = 0;
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(0, root));

        while (!pq.isEmpty()) {
            int size = pq.size();
            long currMin = pq.peek().level;
            long currMax = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = pq.poll();

                long level = curr.level - currMin;
                currMax = level;

                if (curr.node.left != null) {
                    pq.add(new Pair(2 * level + 1, curr.node.left));
                }

                if (curr.node.right != null) {
                    pq.add(new Pair(2 * level + 2, curr.node.right));
                }
            }

            max = (int) Math.max(max, currMax + 1);
        }

        return max;
    }
}
