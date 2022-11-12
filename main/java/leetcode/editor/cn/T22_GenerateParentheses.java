//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2950 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：括号生成
 */
public class T22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new T22_GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            _generate(result, "", 0, 0, n);
            return result;
        }

        private void _generate(List<String> result, String str, int left, int right, int n) {
            // 终止条件
            if (left == n && right == n) {
                result.add(str);
                return;
            }
            // 处理当前逻辑和下探
            // 当左括号没用完的时候，可以继续用左括号
            if (left < n) {
                _generate(result, str + "(", left + 1, right, n);
            }
            // 当右括号小于左括号的时候，可以继续用右括号
            if (right < left) {
                _generate(result, str + ")", left, right + 1, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
