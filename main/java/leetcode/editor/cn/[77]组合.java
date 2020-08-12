package leetcode.editor.cn;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//  1 2 3 4
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 327 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Combine {
    private List<List<Integer>> output = new LinkedList<>();
    int n,k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        _combine(1,new LinkedList<Integer>());

        return output;
    }

    private void _combine(int first, LinkedList<Integer> curr) {
        if(curr.size() == k){
            output.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n+1; i++) {
            curr.add(i);
            _combine(i + 1, curr);
            curr.removeLast();
        }


    }


    public static void main(String[] args) {
        //Integer [] nums = new Integer[]{1,2,3,4};
        new Combine().combine(4, 2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
