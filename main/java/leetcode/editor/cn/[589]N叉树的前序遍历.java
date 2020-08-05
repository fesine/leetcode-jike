package leetcode.editor.cn;//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


import java.util.ArrayList;
import java.util.List;

class PreorderMultNode {
    public List<Integer> preorder(MultNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root != null) {
            nums.add(root.val);
            if (root.children != null) {
                for (MultNode child : root.children) {
                    nums.addAll(preorder(child));
                }
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        MultNode s2 = new MultNode(2);
        MultNode s4 = new MultNode(4);
        MultNode s5 = new MultNode(5);
        MultNode s6 = new MultNode(6);
        List<MultNode> c1 = new ArrayList<>();
        List<MultNode> c3 = new ArrayList<>();
        MultNode s3 = new MultNode(3, c3);
        MultNode root = new MultNode(1, c1);
        c1.add(s3);
        c1.add(s2);
        c1.add(s4);
        c3.add(s5);
        c3.add(s6);
        List<Integer> list = new PreorderMultNode().preorder(root);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
