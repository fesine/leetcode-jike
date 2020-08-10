package leetcode.editor.cn;
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
// Related Topics 树 深度优先搜索 
// 👍 661 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return maxLevel(root, 0);
    }

    private int maxLevel(TreeNode root, int level) {
        if(root == null){
            return level;
        }
        return Math.max(maxLevel(root.left, level + 1), maxLevel(root.right, level + 1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        TreeNode l4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(6);
        TreeNode l6 = new TreeNode(4);
        root.right = right;
        root.left = left;
        left.left = l4;
        right.right = r5;
        right.left = l6;
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
