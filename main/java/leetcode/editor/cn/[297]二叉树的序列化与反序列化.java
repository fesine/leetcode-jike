package leetcode.editor.cn;
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//    3
//   / \
//  2   5
// /   / \
//1   4   6
//[3,2,1,null,null,null,5,4,null,null,6,null,null]
//[3,2,null,1,null,null,5,4,null,null,6,null,null]
//[3,2,1,null,5,4,6]
//[3,2,null,1,5,4,6]
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 330 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //使用前序遍历
        if (root == null) {
            return "[null]";
        }
        StringBuilder s = new StringBuilder("[");

        _serialize(root,s);


        //处理最后的逗号
        return s.substring(0,s.length()-1)+("]");
        
    }

    private void _serialize(TreeNode root, StringBuilder s) {
        if(root == null){
            s.append("null,");
            return;
        }
        s.append(root.val).append(",");
        _serialize(root.left,s);
        _serialize(root.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //处理为空的情况
        if (data == null|| data.contains("[]") || data.contains("[null]")) {
            return null;
        }
        String s = data.substring(1, data.length() - 1);
        String[] a = s.split(",");
        //将数组转换成先进后出队列
        Deque<String> deque = new LinkedList<>(Arrays.asList(a));

        return buildTree(deque);
        
    }

    private TreeNode buildTree(Deque<String> deque) {
        String s =deque.poll();
        if("null".equals(s)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = buildTree(deque);
        node.right = buildTree(deque);
        return node;
    }


    public static void main(String[] args) {
        //TreeNode root = new TreeNode(3);
        //TreeNode left = new TreeNode(2);
        //TreeNode right = new TreeNode(5);
        //TreeNode l4 = new TreeNode(1);
        //TreeNode r5 = new TreeNode(6);
        //TreeNode l6 = new TreeNode(4);
        //root.right = right;
        //root.left = left;
        //left.right = l4;
        //right.right = r5;
        //right.left = l6;
        //System.out.println(new Codec().serialize(root));
        String s = "[3,2,null,1,null,null,5,4,null,null,6,null,null]";
        TreeNode node = new Codec().deserialize(s);
        System.out.println();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
