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
    int pre_idx = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int s , int e) {
        if(s>e) {
            return null;
        }
        int rootVal = preorder[pre_idx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = dfs(preorder, s, mid-1);
        root.right = dfs(preorder, mid+1,e);
        return root;
    }
}
