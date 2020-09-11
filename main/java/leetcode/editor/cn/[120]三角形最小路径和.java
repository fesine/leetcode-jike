package leetcode.editor.cn;
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 589 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //int [][]dp = new int[n+1][n+1];
        //for (int i = n-1; i >= 0; i--) {
        //    for (int j = 0; j <= i ; j++) {
        //        dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
        //    }
        //}
        int []dp = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i ; j++) {
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0];

    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);
        a.add(2);
        b.add(3);
        b.add(4);
        c.add(6);
        c.add(5);
        c.add(7);
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        int i = new MinimumTotal().minimumTotal(triangle);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
