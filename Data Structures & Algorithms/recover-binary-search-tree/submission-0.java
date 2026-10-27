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
    static int i=0;
    public void recoverTree(TreeNode root) {
        i = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        find(root,arr);

        Collections.sort(arr);

        find2(root,arr);
       

        
    }
    static void find2(TreeNode root,ArrayList<Integer> arr){
        if(root==null)return;

       
        find2(root.left,arr);
         if(root.val!=arr.get(i)){
            root.val=arr.get(i);
        }
        i++;
        find2(root.right,arr);
    }
    static void find(TreeNode root,ArrayList<Integer> arr ){
        if(root==null)return;
        find(root.left,arr);
        arr.add(root.val);
        find(root.right,arr);
    }
}