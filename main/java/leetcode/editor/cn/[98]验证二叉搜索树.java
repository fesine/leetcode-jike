package leetcode.editor.cn;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 696 👎 0


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
class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);

    }

    private boolean helper(TreeNode root, Integer left, Integer right) {
        //退出条件
        if(root == null){
            return true;
        }
        int val = root.val;
        if (left != null && val <= left) {
            return false;
        }
        if (right != null && val >= right) {
            return false;
        }
        //将自己的节点当作根节点带入到下一次递归里面进行比较
        if (!helper(root.left, left, val)) {
            return false;
        }
        if (!helper(root.right, val, right)) {
            return false;
        }
        return true;

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
        System.out.println(new IsValidBST().isValidBST(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
