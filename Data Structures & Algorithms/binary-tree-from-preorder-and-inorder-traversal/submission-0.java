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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return build(0,n-1,preorder,0,n-1,inorder);
        
    }
   TreeNode build(int prelo,int prehi,int preorder[],int inlo,int inhi,int inorder[]){
        if(prelo>prehi||inlo>inhi)return null;

        int r=0;
        for(int i=inlo;i<=inhi;i++){
            if(inorder[i]==preorder[prelo]){
                r=i;
                break;
            }
        }
            int count=r-inlo;

            TreeNode root=new TreeNode(preorder[prelo]);
            root.left=build(prelo+1,prelo+count,preorder,inlo,r-1,inorder);
            root.right=build(prelo+count+1,prehi,preorder,r+1,inhi,inorder);
            return root;
        }
    }

