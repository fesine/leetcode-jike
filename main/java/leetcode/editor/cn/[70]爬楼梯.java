package leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1151 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class ClimbStairs {
    public int climbStairs(int n) {
        //1、递归解法
        //if (n <= 2) {
        //    return n;
        //}
        //return climbStairs(n - 1) + climbStairs(n - 2);
        //2、空间换时间解法
        //if(n <= 2){
        //    return n;
        //}
        //int[] c = new int[n+1];
        //c[1]=1;
        //c[2]=2;
        //for (int i = 3; i <= n; i++) {
        //    c [i] = c[i-2] + c[i-1];
        //}
        //return c[n];
        // 第三种，不用数组
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;

    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(6));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
