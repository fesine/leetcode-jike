package leetcode.editor.cn;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 314 👎 0


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
class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int min= Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(minDepth(root.left), min);
        }
        if(root.right != null){
            min = Math.min(minDepth(root.right), min);
        }
        return min+1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        //TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        //TreeNode l4 = new TreeNode(1);
        //TreeNode r5 = new TreeNode(6);
        //TreeNode l6 = new TreeNode(4);
        root.right = right;
        //root.left = left;
        //left.left = l4;
        //right.right = r5;
        //right.left = l6;
        System.out.println(new MinDepth().minDepth(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
