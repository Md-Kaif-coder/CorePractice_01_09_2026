/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = findRoot(p,q);
        return lca(root,p,q);
    }
    static Node findRoot(Node p,Node q){
        if(p.parent==null)return p;
        if(q.parent==null)return q;
        return findRoot(p.parent,q.parent);
    }
    static Node lca(Node root,Node p,Node q){
        if(root==null)return root;
        if(root.val==p.val||root.val==q.val)return root;
        Node left=lca(root.left,p,q);
        Node right = lca(root.right,p,q);
        if(left!=null && right!=null)return root;
        return (left==null)? right:left;
    }
}