package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1216 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesis {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        _generate(0,0,n,"");

        return null;

    }

    private void _generate(int left, int right, int max, String s) {
        //1、退出条件
        if (left == max && right == max) {
            result.add(s);
            return;
        }

        //2、处理当前数据
        if(left < max){
            _generate(left + 1, right, max, s + "(");
        }
        if(left > right){
            _generate(left, right+1, max, s + ")");
        }

        //3、递归处理

        //4、清理数据
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
