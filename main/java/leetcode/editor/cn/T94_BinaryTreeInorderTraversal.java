//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1615 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Java：二叉树的中序遍历
 */
public class T94_BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new T94_BinaryTreeInorderTraversal().new Solution();
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
        List<Integer> list = solution.inorderTraversal(root);
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归 左根右 中序遍历
        List<Integer> nums = new ArrayList<>();
        //if (root != null) {
        //    nums.addAll(inorderTraversal(root.left));
        //    nums.add(root.val);
        //    nums.addAll(inorderTraversal(root.right));
        //}
        // 使用栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 将根入栈
                stack.push(cur);
                // 遍历左节点
                cur = cur.left;
            }
            // 左节点为空，弹出当前节点
            cur = stack.pop();
            nums.add(cur.val);
            // 右节点入栈
            cur = cur.right;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
