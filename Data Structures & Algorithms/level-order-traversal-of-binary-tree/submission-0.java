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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null && queue.isEmpty()) {
                res.add(new ArrayList(level));
                break;
            }
            if(curr == null) {
                res.add(new ArrayList(level));
                level.clear();
                queue.add(null);
                continue;
            }
            level.add(curr.val);
            if(curr.left!=null) {
                queue.add(curr.left);
            }
            if(curr.right!=null) {
                queue.add(curr.right);
            }
        }
        return res;
    }
}
