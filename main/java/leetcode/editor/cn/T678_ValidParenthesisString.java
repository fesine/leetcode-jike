//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 
// 👍 535 👎 0


package leetcode.editor.cn;

import java.util.Stack;

/**
 * Java：有效的括号字符串
 */
public class T678_ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new T678_ValidParenthesisString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidString(String s) {
            // 使用两个栈分别存放（和*的下标
            Stack<Integer> left = new Stack<>();
            Stack<Integer> star = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if ('(' == s.charAt(i)) {
                    left.push(i);
                } else if ('*' == s.charAt(i)) {
                    star.push(i);
                } else {
                    // 先用(
                    if (!left.isEmpty()) {
                        left.pop();
                    } else if (!star.isEmpty()) {
                        // 再用*替代(
                        star.pop();
                    } else {
                        // 如果两个栈均空，说明没有匹配)的符号可以用
                        return false;
                    }
                }
            }
            // 还有(
            while (!left.isEmpty()) {
                // 如果没有*可用，匹配失败
                if (star.isEmpty()) {
                    return false;
                }
                // 当(的下标大于*，匹配失败
                if (left.pop() > star.pop()) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
