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
    public boolean isBalanced(TreeNode root) {
        if(true) {
            return dfs(root)[0]==1;
        }
        if(root==null)
        return true;
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r)>1)
        return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ls = height(root.left);
        int rs = height(root.right);
        return 1 + Math.max(ls, rs);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{1, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        boolean balanced = (left[0]==1 && right[0]==1) && (Math.abs(left[1]-right[1])<=1);
        int height = 1 + Math.max(left[1], right[1]);
        return new int[]{balanced?1:0, height};
    }
}
