package leetcode.editor.cn;
//给定一个二叉树，返回它的中序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 605 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        //1.递归实现
        //if (root != null) {
        //    nums.addAll(inorderTraversal(root.left));
        //    nums.add(root.val);
        //    nums.addAll(inorderTraversal(root.right));
        //}
        //2.迭代实现 通过栈
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nums.add(cur.val);
            cur = cur.right;
        }
        return nums;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);
        root.right = right;
        root.left = left;
        left.left = l4;
        left.right=r5;
        right.left=l6;
        List<Integer> list = new InorderTraversal().inorderTraversal(root);
        System.out.println();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
