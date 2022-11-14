//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 1070 👎 0


package leetcode.editor.cn;

/**
 * Java：Pow(x, n)
 */
public class T50_PowxN {
    public static void main(String[] args) {
        Solution solution = new T50_PowxN().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            return fastPow(x, n);
        }

        private double fastPow(double x, int n) {
            if (n == 0) {
                return 1.0;
            }
            double result = fastPow(x, n / 2);
            return n % 2 == 0 ? result * result : result * result * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
