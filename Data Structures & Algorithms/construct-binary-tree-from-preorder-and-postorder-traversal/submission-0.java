class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return build(preorder, 0, n - 1, postorder, 0, n - 1);
    }
    TreeNode build(int[] pre, int prelo, int prehi, int[] post, int polo, int pohi) {
        if (prelo > prehi || polo > pohi) {
            return null;
        }

        TreeNode node = new TreeNode(pre[prelo]);

        if (prelo == prehi)
            return node;

        int r = 0;
        for (int i = 0; i <= pohi; i++) {
            if (pre[prelo + 1] == post[i]) {
                r = i;
                break;
            }
        }
        int count = r - polo + 1;
        node.left = build(pre, prelo + 1, prelo + count, post, polo, r);
        node.right = build(pre, prelo + count + 1, prehi, post, r + 1, pohi - 1);
        return node;
    }
}