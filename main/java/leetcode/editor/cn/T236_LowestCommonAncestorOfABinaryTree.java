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
        solution.lowestCommonAncestor(root,l5,r4);
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
        ParentNode p1 = map.get(p.val);
        ParentNode q1 = map.get(q.val);
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        stack1.add(p);
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack2.add(q);
        while (p1 != null) {
            stack1.add(p1.parent);
            p1 = map.get(p1.parent.val);
        }
        while (q1 != null) {
            stack2.add(q1.parent);
            q1 = map.get(q1.parent.val);
        }
        int min = Math.min(stack1.size(), stack2.size());
        while (stack1.size() > min) {
            stack1.removeFirst();
        }
        while (stack2.size() > min) {
            stack2.removeFirst();
        }
        while (stack1.getFirst() != stack2.getFirst()) {
            stack1.removeFirst();
            stack2.removeFirst();
        }
        return stack1.getFirst();
    }

    private void fillMap(Map<Integer, ParentNode> map, TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, new ParentNode(root.left.val, root));
            fillMap(map,root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, new ParentNode(root.right.val, root));
            fillMap(map,root.right);
        }
    }

    class ParentNode {
        int val;
        TreeNode parent;

        public ParentNode(int val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
