//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 1512 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Java：二叉树的层序遍历
 */
public class T102_BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new T102_BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 广度优先遍历，使用deque
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            Deque<TreeNode> nodes = new LinkedList<>();
            // 添加当前层到list中
            for (TreeNode node : deque) {
                // 按层遍历
                sub.add(node.val);
                // 将子节点添加到队列中
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }
            // 添加结果
            result.add(sub);
            // 将队列再赋给deque
            deque = nodes;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
