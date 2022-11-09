//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 940 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Java：二叉树的前序遍历
 */
public class T144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new T144_BinaryTreePreorderTraversal().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);
        root.right = right;
        root.left = left;
        left.left = l4;
        left.right = r5;
        right.left = l6;
        List<Integer> list = solution.preorderTraversal(root);
        System.out.println();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 递归 根左右 前序遍历
        List<Integer> nums = new ArrayList<>();
        //if (root != null) {
        //    nums.add(root.val);
        //    nums.addAll(preorderTraversal(root.left));
        //    nums.addAll(preorderTraversal(root.right));
        //}
        // 使用栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            // 取出root
            cur = stack.pop();
            nums.add(cur.val);
            // 右节点入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
