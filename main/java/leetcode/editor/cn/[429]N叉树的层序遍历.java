package leetcode.editor.cn;
//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 100 👎 0


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

class LevelOrderMultNode {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrder(MultNode root) {
        if (root != null) {
            traverseNode(root, 0);
        }
        return lists;
    }

    private void traverseNode(MultNode node,int level){
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(node.val);
        if (node.children != null) {
            for (MultNode subNode : node.children) {
                traverseNode(subNode, level + 1);
            }
        }
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
        List<List<Integer>> list = new LevelOrderMultNode().levelOrder(root);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
