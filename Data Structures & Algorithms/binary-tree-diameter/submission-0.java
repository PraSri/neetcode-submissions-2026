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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 3 cases 
        int case1 = height(root.left) + height(root.right);
        int case2 = diameterOfBinaryTree(root.left);
        int case3 = diameterOfBinaryTree(root.right);
        return Math.max(case1, Math.max(case2, case3));
    }

    private int height(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
