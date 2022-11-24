//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 2043 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Java：二叉树的最近公共祖先
 */
public class T236_LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new T236_LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode l5 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        TreeNode l6 = new TreeNode(6);
        TreeNode r2 = new TreeNode(2);
        TreeNode l0 = new TreeNode(0);
        TreeNode r8 = new TreeNode(8);
        TreeNode l7 = new TreeNode(7);
        TreeNode r4 = new TreeNode(4);
        root.right = r1;
        root.left = l5;
        l5.left = l6;
        l5.right = r2;
        r2.left = l7;
        r2.right = r4;
        r1.left = l0;
        r1.right = r8;
        System.out.println(solution.lowestCommonAncestor(root, l5, r4).val);
        // TO TEST
    }
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
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, ParentNode> map = new HashMap<>();
        map.put(root.val, null);
        fillMap(map,root);
        // 取出p和q在map中的节点
        ParentNode p1 = map.get(p.val);
        ParentNode q1 = map.get(q.val);
        // 分别存放两个节点的父节点
        LinkedList<TreeNode> deque1 = new LinkedList<>();
        deque1.add(p);
        LinkedList<TreeNode> deque2 = new LinkedList<>();
        deque2.add(q);
        while (p1 != null) {
            // 添加p的父节点，层级越高的父节点，越在前面
            deque1.addFirst(p1.parent);
            // 再从map中取出p1的父节点node
            p1 = map.get(p1.parent.val);
        }
        while (q1 != null) {
            deque2.addFirst(q1.parent);
            q1 = map.get(q1.parent.val);
        }
        int min = Math.min(deque1.size(), deque2.size());
        // 保证数量相同，从下往上删除多余的节点，size小的节点肯定在上面
        while (deque1.size() > min) {
            deque1.removeLast();
        }
        while (deque2.size() > min) {
            deque2.removeLast();
        }
        while (deque1.getLast() != deque2.getLast()) {
            deque1.removeLast();
            deque2.removeLast();
        }
        return deque1.getLast();
    }

    /**
     * 将所有节点添加到map中
     * @param map
     * @param root
     */
    private void fillMap(Map<Integer, ParentNode> map, TreeNode root) {
        // 填充左节点map
        if (root.left != null) {
            map.put(root.left.val, new ParentNode(root.left.val, root));
            fillMap(map,root.left);
        }
        // 填充右节点map
        if (root.right != null) {
            map.put(root.right.val, new ParentNode(root.right.val, root));
            fillMap(map,root.right);
        }
    }

    /**
     * 定义包含父节点属性的类
     */
    class ParentNode {
        /**
         * 当前值
         */
        int val;
        /**
         * 父节点
         */
        TreeNode parent;

        public ParentNode(int val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
