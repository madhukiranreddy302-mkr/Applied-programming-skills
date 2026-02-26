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
    public int i = 0;
    public TreeNode rec(TreeNode node, int k) {
        if(node == null)
            return null;

        TreeNode ans = null;
        if ((ans = rec(node.left, k)) != null)
            return ans;

        if(++i == k)
            return node;

        if ((ans = rec(node.right, k)) != null)
            return ans;

        return null;
    }
    public int kthSmallest(TreeNode root, int k) {
        return rec(root, k).val;
    }
}