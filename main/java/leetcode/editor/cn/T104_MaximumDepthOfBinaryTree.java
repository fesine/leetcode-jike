//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1426 👎 0


package leetcode.editor.cn;

/**
 * Java：二叉树的最大深度
 */
public class T104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new T104_MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            return maxLevel(root, 0);
        }

        private int maxLevel(TreeNode root, int level) {
            if (root == null) {
                return level;
            }
            // 递归获取左子节点和右子节点的最大深度
            return Math.max(maxLevel(root.left, level + 1), maxLevel(root.right, level + 1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
