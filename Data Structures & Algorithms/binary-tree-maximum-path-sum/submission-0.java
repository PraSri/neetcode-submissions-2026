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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{root.val};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if(root == null) {
            return 0;
        }
        int l = Math.max(0, dfs(root.left, res));
        int r = Math.max(0, dfs(root.right, res));
        
        res[0] = Math.max(res[0], l + r + root.val);

        return root.val + Math.max(l,r);

    }
}
